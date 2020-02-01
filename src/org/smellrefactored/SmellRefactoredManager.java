package org.smellrefactored;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.designroleminer.smelldetector.model.LimiarTecnica;
import org.refactoringminer.api.GitService;
import org.refactoringminer.util.GitServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smellrefactored.refactoringminer.wrapper.RefactoringMinerWrapperManager;
import org.smellrefactored.refactoringminer.wrapper.RefactoringMinerWrapperDto;

public class SmellRefactoredManager {

	final boolean ANALYZE_FIRST_COMMIT_ONLY = true; // Very, very, very slow!

	final boolean USE_SMELLS_COMMIT_OLD_CACHE = false; // This can ignore new adjustments in DesignRoleMiner.

	static Logger logger = LoggerFactory.getLogger(SmellRefactoredManager.class);

	private String urlRepository;
	private String repositoryPath;
	private String initialCommitId;
	private String finalCommitId;
	private List<LimiarTecnica> listaLimiarTecnica;

	private CommitRange commitRange;
	private RefactoringEvents refactoringEvents;
	
	
	private ArrayList<String> smellCommitIds = new ArrayList<String>(); 
	private CommitSmell commitSmell;
	
	private String resultBaseFileName;


	HashSet<String> listCommitEvaluated = new HashSet<String>();
	
	public SmellRefactoredManager(String urlRepository, String repositoryPath, String initialCommitId, String finalCommitId,
			List<LimiarTecnica> listaLimiarTecnica, String resultBaseFileName) {
		this.urlRepository = urlRepository;
		this.repositoryPath = repositoryPath;
		this.initialCommitId = initialCommitId;
		this.finalCommitId = finalCommitId;
		this.listaLimiarTecnica = listaLimiarTecnica;
		this.resultBaseFileName = resultBaseFileName;

		try {
			prepareSmellRefactored();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	private void prepareSmellRefactored() throws Exception {
		if (initialCommitId.equals(finalCommitId)) {
			throw new Exception("At least 2 commits are required in the range of commits to be analyzed.");
		}

		GitService gitService = new GitServiceImpl();
		gitService.cloneIfNotExists(repositoryPath, urlRepository);
		commitRange = new CommitRange(repositoryPath, initialCommitId, finalCommitId);
		
		RefactoringMinerWrapperManager refactoringMinerWrapperManager = new RefactoringMinerWrapperManager(repositoryPath, commitRange.getNextCommit(initialCommitId).getId(), finalCommitId, resultBaseFileName);
		List<RefactoringMinerWrapperDto> refactoringDtoList = refactoringMinerWrapperManager.getRefactoringDtoListUsingJsonCache();
		refactoringEvents = new RefactoringEvents(refactoringDtoList, this.repositoryPath);
		logger.info("Total de refactorings encontrados: " + refactoringEvents.size());

		HashSet<String> commitsWithRefactorings = refactoringMinerWrapperManager.getCommitsWithRefactoringsFromRefactoringList(refactoringDtoList);
		ArrayList<CommitData> commitsWithRefactoringMergedIntoMaster = commitRange.getCommitsMergedIntoMasterByIds(commitsWithRefactorings);

		if (ANALYZE_FIRST_COMMIT_ONLY) {
			smellCommitIds.add(initialCommitId);
		} else {
			smellCommitIds = commitRange.getIds();
			smellCommitIds.remove(finalCommitId);
		}
		
		commitSmell = new CommitSmell(repositoryPath, commitsWithRefactoringMergedIntoMaster, listaLimiarTecnica, resultBaseFileName);
		commitSmell.useOldCache(USE_SMELLS_COMMIT_OLD_CACHE);
	}

	public void getSmellRefactoredMethods() {
		try {
			SmellRefactoredMethod smellRefactoredMethod = new SmellRefactoredMethod(refactoringEvents, smellCommitIds, commitRange, commitSmell, resultBaseFileName);
			smellRefactoredMethod.getSmellRefactoredMethods();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public void getSmellRefactoredClasses() {
		try {
			SmellRefactoredClass smellRefactoredClass = new SmellRefactoredClass(refactoringEvents, smellCommitIds, commitRange, commitSmell, resultBaseFileName);
			smellRefactoredClass.getSmellRefactoredClasses();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

}
