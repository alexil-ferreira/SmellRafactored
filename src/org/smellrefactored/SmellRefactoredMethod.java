package org.smellrefactored;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;

import org.designroleminer.smelldetector.model.FilterSmellResult;
import org.designroleminer.smelldetector.model.MethodDataSmelly;
import org.refactoringminer.api.RefactoringType;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.persistence.csv.CSVFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmellRefactoredMethod {

	private boolean ANALYZE_EACH_REFACTORING_TYPE_BY_SMELL = true;
	
	private HashSet<String> getLongMethodRefactoringTypes() {
		HashSet<String> refactoringTypes = new HashSet<String>();
		refactoringTypes.add(RefactoringType.EXTRACT_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.RENAME_METHOD.toString());
		// refactoringTypes.add(RefactoringType.INLINE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MOVE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MOVE_AND_RENAME_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.PULL_UP_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.PUSH_DOWN_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MERGE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.EXTRACT_AND_MOVE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MOVE_AND_INLINE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.CHANGE_METHOD_SIGNATURE.toString());
		// refactoringTypes.add(RefactoringType.CHANGE_RETURN_TYPE.toString());
		return refactoringTypes;
	}

	private HashSet<String> getComplexMethodRefactoringTypes() {
		HashSet<String> refactoringTypes = new HashSet<String>();
		refactoringTypes.add(RefactoringType.EXTRACT_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.RENAME_METHOD.toString());
		// refactoringTypes.add(RefactoringType.INLINE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MOVE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MOVE_AND_RENAME_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.PULL_UP_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.PUSH_DOWN_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MERGE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.EXTRACT_AND_MOVE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MOVE_AND_INLINE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.CHANGE_METHOD_SIGNATURE.toString());
		// refactoringTypes.add(RefactoringType.CHANGE_RETURN_TYPE.toString());
		return refactoringTypes;
	}
	
	private HashSet<String> getHighEfferentCouplingRefactoringTypes() {
		HashSet<String> refactoringTypes = new HashSet<String>();
		refactoringTypes.add(RefactoringType.EXTRACT_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.RENAME_METHOD.toString());
		// refactoringTypes.add(RefactoringType.INLINE_OPERATION.toString());
		refactoringTypes.add(RefactoringType.MOVE_OPERATION.toString());
		refactoringTypes.add(RefactoringType.MOVE_AND_RENAME_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.PULL_UP_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.PUSH_DOWN_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MERGE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.EXTRACT_AND_MOVE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MOVE_AND_INLINE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.CHANGE_METHOD_SIGNATURE.toString());
		// refactoringTypes.add(RefactoringType.CHANGE_RETURN_TYPE.toString());
		return refactoringTypes;
	}

	private HashSet<String> getManyParametersRefactoringTypes() {
		HashSet<String> refactoringTypes = new HashSet<String>();
		refactoringTypes.add(RefactoringType.EXTRACT_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.RENAME_METHOD.toString());
		// refactoringTypes.add(RefactoringType.INLINE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MOVE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MOVE_AND_RENAME_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.PULL_UP_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.PUSH_DOWN_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MERGE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.EXTRACT_AND_MOVE_OPERATION.toString());
		// refactoringTypes.add(RefactoringType.MOVE_AND_INLINE_OPERATION.toString());
		refactoringTypes.add(RefactoringType.CHANGE_METHOD_SIGNATURE.toString());
		// // refactoringTypes.add(RefactoringType.CHANGE_RETURN_TYPE.toString());
		return refactoringTypes;
	}
	
	
	private HashSet<String> getClassRenameRefactoringTypes() {
		HashSet<String> refactoringTypes = new HashSet<String>();
		refactoringTypes.add(RefactoringType.RENAME_CLASS.toString());
		refactoringTypes.add(RefactoringType.MOVE_CLASS.toString());
		refactoringTypes.add(RefactoringType.MOVE_RENAME_CLASS.toString());
		/// refactoringTypes.add(RefactoringType.MOVE_SOURCE_FOLDER.toString());
		/// refactoringTypes.add(RefactoringType.RENAME_PACKAGE.toString());
		return refactoringTypes;
	}

	private HashSet<String> getMethodRenameRefactoringTypes() {
		HashSet<String> refactoringTypes = new HashSet<String>();
		// Original: refactoringTypes.add(RefactoringType.RENAME_METHOD.toString());
		refactoringTypes.add(RefactoringType.RENAME_METHOD.toString());
		refactoringTypes.add(RefactoringType.MOVE_OPERATION.toString());
		refactoringTypes.add(RefactoringType.MOVE_AND_RENAME_OPERATION.toString());
		refactoringTypes.add(RefactoringType.PULL_UP_OPERATION.toString());
		refactoringTypes.add(RefactoringType.PUSH_DOWN_OPERATION.toString());
		refactoringTypes.add(RefactoringType.EXTRACT_AND_MOVE_OPERATION.toString());
		refactoringTypes.add(RefactoringType.MOVE_AND_INLINE_OPERATION.toString());
		/// refactoringTypes.add(RefactoringType.RENAME_CLASS.toString());
		/// refactoringTypes.add(RefactoringType.MOVE_CLASS.toString());
		/// refactoringTypes.add(RefactoringType.MOVE_RENAME_CLASS.toString());
		/// refactoringTypes.add(RefactoringType.MOVE_SOURCE_FOLDER.toString());
		/// refactoringTypes.add(RefactoringType.RENAME_PACKAGE.toString());
		return refactoringTypes;
	}
	
	
	private HashSet<String> getMethodRefactoringTypes() {
		HashSet<String> refactoringTypes = new HashSet<String>();
		// smells refactoring...
		refactoringTypes.addAll(this.getLongMethodRefactoringTypes());
		refactoringTypes.addAll(this.getComplexMethodRefactoringTypes());
		refactoringTypes.addAll(this.getHighEfferentCouplingRefactoringTypes());
		refactoringTypes.addAll(this.getManyParametersRefactoringTypes());
		// and rename...
		refactoringTypes.addAll(this.getClassRenameRefactoringTypes());
		refactoringTypes.addAll(this.getMethodRenameRefactoringTypes());
		return refactoringTypes;
	}

	
	LinkedHashMap<String, Integer> refactoringsCounter = new LinkedHashMap<String, Integer>();  
	
	static Logger logger = LoggerFactory.getLogger(SmellRefactoredManager.class);

	ArrayList<RefactoringData> listRefactoring;
	private String initialCommit;
	ArrayList<CommitData> commitsMergedIntoMaster;
	String resultFileName;
	
	PersistenceMechanism pmResultEvaluationMethods;
	PersistenceMechanism pmResultSmellRefactoredMethods;
	PersistenceMechanism pmResultSmellRefactoredMethodsMessage;
	PersistenceMechanism pmResultSmellRefactoredMethodsMachineLearning;
	
	CommitSmell commitSmell;

	public SmellRefactoredMethod(ArrayList<RefactoringData> listRefactoring, String initialCommit, ArrayList<CommitData> commitsMergedIntoMaster, CommitSmell commitSmell, String resultFileName) {
		this.listRefactoring = listRefactoring;
		this.initialCommit = initialCommit;
		this.commitsMergedIntoMaster = commitsMergedIntoMaster;
		this.commitSmell = commitSmell;
		this.resultFileName = resultFileName;
		
		pmResultEvaluationMethods = new CSVFile(resultFileName + "-evaluation-methods.csv", false);
		pmResultSmellRefactoredMethods = new CSVFile(resultFileName + "-smellRefactored-methods.csv", false);
		pmResultSmellRefactoredMethodsMessage = new CSVFile(resultFileName + "-smellRefactored-methods-message.csv", false);
		pmResultSmellRefactoredMethodsMachineLearning = new CSVFile(resultFileName + "-smellRefactored-methods-machineLearning.csv", false);
	}
	
	public void getSmellRefactoredMethods() {
		try {
			int countRefactoringRelatedMethods = 0;
			int countRefactoringRelatedClassRenaming = 0;
			int countRefactoringRelatedMethodRenaming = 0;
			int countRefactoringRelatedLongMethod = 0;
			int countRefactoringRelatedComplexMethod = 0;
			int countRefactoringRelatedHighEfferentCoupling = 0;
			int countRefactoringRelatedManyParameters = 0;

			for (String refactoringType: getMethodRefactoringTypes()) {
				refactoringsCounter.put(refactoringType, 0);
			}
			ArrayList<RefactoringData> listRefactoringMergedIntoMaster = new ArrayList<RefactoringData>();
			for (RefactoringData refactoring : listRefactoring) {
				for (CommitData commit : commitsMergedIntoMaster) {
					if (refactoring.getCommit().equals(commit.getId())) {
						refactoring.setCommitDate(commit.getDate());
						refactoring.setFullMessage(commit.getFullMessage());
						refactoring.setShortMessage(commit.getShortMessage());
						listRefactoringMergedIntoMaster.add(refactoring);
						if (this.getMethodRefactoringTypes().contains(refactoring.getRefactoringType())) {
							if (refactoring.getNomeClasse() == null) {
								logger.error("NULL class name for " + refactoring.getRefactoringType() + " refactoring type: " + refactoring.getNomeClasse());
							}
							if (refactoring.getNomeClasse().contains("[") || refactoring.getNomeClasse().contains("]") || refactoring.getNomeClasse().contains(",") || refactoring.getNomeClasse().contains(" ")) {
								logger.error("DIRTY class name for " + refactoring.getRefactoringType() + " refactoring type: " + refactoring.getNomeClasse());
							}
							if (!this.getClassRenameRefactoringTypes().contains(refactoring.getRefactoringType())) {
								if (refactoring.getNomeMetodo() == null) {
									logger.error("NULL method name for " + refactoring.getRefactoringType() + " refactoring type: " + refactoring.getNomeMetodo());
								}
								if (refactoring.getNomeMetodo().contains("[") || refactoring.getNomeMetodo().contains("]") || refactoring.getNomeMetodo().contains(",") || refactoring.getNomeMetodo().contains(" ")) {
									logger.error("DIRTY method name for " + refactoring.getRefactoringType() + " refactoring type: " + refactoring.getNomeMetodo());
								}
							}
							countRefactoringRelatedMethods++;
							refactoringsCounter.put(refactoring.getRefactoringType(), refactoringsCounter.getOrDefault(refactoring.getRefactoringType(), 0) +1);
						}
						if (this.getClassRenameRefactoringTypes().contains(refactoring.getRefactoringType())) {
							countRefactoringRelatedClassRenaming++;
						}
						if (this.getMethodRenameRefactoringTypes().contains(refactoring.getRefactoringType())) {
							countRefactoringRelatedMethodRenaming++;
						}

						if (this.getLongMethodRefactoringTypes().contains(refactoring.getRefactoringType())) {
							countRefactoringRelatedLongMethod++;
						}
						if (this.getComplexMethodRefactoringTypes().contains(refactoring.getRefactoringType())) {
							countRefactoringRelatedComplexMethod++;
						}
						if (this.getHighEfferentCouplingRefactoringTypes().contains(refactoring.getRefactoringType())) {
							countRefactoringRelatedHighEfferentCoupling++;
						}
						if (this.getManyParametersRefactoringTypes().contains(refactoring.getRefactoringType())) {
							countRefactoringRelatedManyParameters++;
						}
					}
				}
			}
			Collections.sort(listRefactoringMergedIntoMaster);
			
			pmResultEvaluationMethods.write("RELATORIO COMPLETO SISTEMA");
			
			pmResultEvaluationMethods.write("Numero de Refatoracoes em Metodos e Nao Metodos:", listRefactoringMergedIntoMaster.size());
			pmResultEvaluationMethods.write("Numero de Refatoracoes relacionadas a operacoes em Metodos:", countRefactoringRelatedMethods, getMethodRefactoringTypes());
			pmResultEvaluationMethods.write("Numero de Refatoracoes relacionadas a rename em Classes:", countRefactoringRelatedClassRenaming, getClassRenameRefactoringTypes());
			pmResultEvaluationMethods.write("Numero de Refatoracoes relacionadas a rename em Metodos:", countRefactoringRelatedMethodRenaming, getMethodRenameRefactoringTypes());
			pmResultEvaluationMethods.write("Numero de refatoracoes relacionadas a " + MethodDataSmelly.LONG_METHOD + ":", countRefactoringRelatedLongMethod, getLongMethodRefactoringTypes());
			pmResultEvaluationMethods.write("Numero de refatoracoes relacionadas a " + MethodDataSmelly.COMPLEX_METHOD + ":", countRefactoringRelatedComplexMethod, getComplexMethodRefactoringTypes());
			pmResultEvaluationMethods.write("Numero de refatoracoes relacionadas a " + MethodDataSmelly.HIGH_EFFERENT_COUPLING + ":", countRefactoringRelatedHighEfferentCoupling, getHighEfferentCouplingRefactoringTypes());
			pmResultEvaluationMethods.write("Numero de refatoracoes relacionadas a " + MethodDataSmelly.MANY_PARAMETERS + ":", countRefactoringRelatedManyParameters, getManyParametersRefactoringTypes());

			for (String refactoringType: refactoringsCounter.keySet()) {
				pmResultEvaluationMethods.write("Numero de refatoracoes do tipo " + refactoringType + ":", refactoringsCounter.getOrDefault(refactoringType, 0));
			}
			

			FilterSmellResult smellsCommitInitial = this.commitSmell.obterSmellsCommit(initialCommit);

			pmResultEvaluationMethods.write("Numero Metodos Smell Commit Inicial:",
					smellsCommitInitial.getMetodosSmell().size());
			pmResultEvaluationMethods.write("Numero Metodos NOT Smell Commit Inicial:",
					smellsCommitInitial.getMetodosNotSmelly().size());

			pmResultSmellRefactoredMethodsMessage.write("Class", "Method", "Smell", "LOC", "CC", "EC", "NOP",
					"Tecnicas", "Commit", "Refactoring", "Left Side", "Right Side", "Full Message");
			pmResultSmellRefactoredMethods.write("Class", "Method", "Smell", "LOC", "CC", "EC", "NOP", "Tecnicas",
					"Commit", "Refactoring", "Left Side", "Right Side");
			pmResultSmellRefactoredMethodsMachineLearning.write("DesignRole", "LOC", "CC", "EC", "NOP", "isRefactoring", "Refactoring");

			// LONG_METHOD
			evaluateSmellChangeOperation(smellsCommitInitial, listRefactoringMergedIntoMaster, MethodDataSmelly.LONG_METHOD, this.getLongMethodRefactoringTypes());
			if ( (ANALYZE_EACH_REFACTORING_TYPE_BY_SMELL) && (this.getLongMethodRefactoringTypes().size() > 1) ) {
				for (String smellRefactoringType : this.getLongMethodRefactoringTypes()) {
					evaluateSmellChangeOperation(smellsCommitInitial, listRefactoringMergedIntoMaster, MethodDataSmelly.LONG_METHOD, new HashSet<String>(Arrays.asList(smellRefactoringType)));
				}
			}
			
			// COMPLEX_METHOD
			evaluateSmellChangeOperation(smellsCommitInitial, listRefactoringMergedIntoMaster, MethodDataSmelly.COMPLEX_METHOD, this.getComplexMethodRefactoringTypes());
			if ( (ANALYZE_EACH_REFACTORING_TYPE_BY_SMELL) && (this.getComplexMethodRefactoringTypes().size() > 1) ) {
				for (String smellRefactoringType : this.getComplexMethodRefactoringTypes()) {
					evaluateSmellChangeOperation(smellsCommitInitial, listRefactoringMergedIntoMaster, MethodDataSmelly.COMPLEX_METHOD, new HashSet<String>(Arrays.asList(smellRefactoringType)));
				}
			}

			// HIGH_EFFERENT_COUPLING
			evaluateSmellChangeOperation(smellsCommitInitial, listRefactoringMergedIntoMaster, MethodDataSmelly.HIGH_EFFERENT_COUPLING, this.getHighEfferentCouplingRefactoringTypes());
			if ( (ANALYZE_EACH_REFACTORING_TYPE_BY_SMELL) && (this.getHighEfferentCouplingRefactoringTypes().size() > 1) ) {
				for (String smellRefactoringType : this.getHighEfferentCouplingRefactoringTypes()) {
					evaluateSmellChangeOperation(smellsCommitInitial, listRefactoringMergedIntoMaster, MethodDataSmelly.HIGH_EFFERENT_COUPLING, new HashSet<String>(Arrays.asList(smellRefactoringType)));
				}
			}

			// MANY_PARAMETERS
			evaluateSmellChangeParameters(smellsCommitInitial, listRefactoringMergedIntoMaster, MethodDataSmelly.MANY_PARAMETERS, this.getManyParametersRefactoringTypes());
			if ( (ANALYZE_EACH_REFACTORING_TYPE_BY_SMELL) && (this.getManyParametersRefactoringTypes().size() > 1) ) {
				for (String smellRefactoringType : this.getManyParametersRefactoringTypes()) {
					// evaluateSmellChangeOperation(smellsCommitInitial, listRefactoringMergedIntoMaster, MethodDataSmelly.MANY_PARAMETERS, new HashSet<String>(Arrays.asList(smellRefactoringType)));
					evaluateSmellChangeParameters(smellsCommitInitial, listRefactoringMergedIntoMaster, MethodDataSmelly.MANY_PARAMETERS, new HashSet<String>(Arrays.asList(smellRefactoringType)));
				}
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	private void evaluateSmellChangeOperation(FilterSmellResult commitInitial,
			ArrayList<RefactoringData> listRefactoring, String typeSmell, HashSet<String> targetTefactoringTypes) throws Exception {

		ConfusionMatrixPredictors confusionMatrices = new ConfusionMatrixPredictors(typeSmell + " " + targetTefactoringTypes.toString(), this.commitSmell.getTechniquesThresholds().keySet());
		
		// TP e FN
		computeTruePositiveAndFalseNegative(listRefactoring, typeSmell, targetTefactoringTypes, confusionMatrices);
		// FP
/// @TODO: Bug esse m�todo computa alguns falsos positivos a mais
computeFalsePositive(commitInitial, listRefactoring, typeSmell, targetTefactoringTypes, confusionMatrices);
		// TN
        computeTrueNegativeCommon(commitInitial, listRefactoring, typeSmell, targetTefactoringTypes, confusionMatrices);
		computeTrueNegativeIndividual(commitInitial, listRefactoring, typeSmell, targetTefactoringTypes, confusionMatrices);
		
		
		int realPositive = SmellRefactoredManager.countRealPositive(refactoringsCounter, targetTefactoringTypes);
		confusionMatrices.setValidationRealPositive(realPositive);
		for (String technique : this.commitSmell.getTechniquesThresholds().keySet()) {
			Integer positivePredictionExpected = countPositivePredictionForTechnique(commitInitial, typeSmell, technique);
			confusionMatrices.setValidationPositivePrediction(technique, positivePredictionExpected);
		}
		
		pmResultEvaluationMethods.write("");
		confusionMatrices.writeToCsvFile(pmResultEvaluationMethods);
	
	}
	
	
	private void computeTrueNegativeIndividual(FilterSmellResult commitInitial,
			ArrayList<RefactoringData> listRefactoring, String typeSmell, HashSet<String> targetTefactoringTypes,
			ConfusionMatrixPredictors confusionMatrices) throws Exception {
		for (MethodDataSmelly methodSmelly : commitInitial.getMetodosSmell()) {
			if (methodSmelly.getSmell().equals(typeSmell)) {
				MethodDataSmelly methodSmellyBuscar = methodSmelly;
				boolean renamedMethod = false;
				Date dateCommitRenamed = null;
				PredictionRound predictionRound = confusionMatrices.newRound();
				predictionRound.setDefaultCondition(false);
				do {
					renamedMethod = false;
					String classRenamedName = null;
					String methodRenamedName = null;
					for (RefactoringData methodRefactored : listRefactoring) {
						if ( (!this.getMethodRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) && (!targetTefactoringTypes.contains(methodRefactored.getRefactoringType())) ) {
							continue;
						}
						if (!methodRefactored.getNomeClasse().equals(methodSmellyBuscar.getNomeClasse())) {
							continue;
						}
						if (this.getClassRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) {
							if ((dateCommitRenamed == null) || ( (dateCommitRenamed != null)
									&& (dateCommitRenamed.compareTo(methodRefactored.getCommitDate()) < 0)) ) {
								renamedMethod = true;
								dateCommitRenamed = methodRefactored.getCommitDate();
								classRenamedName = methodRefactored.getRightSide();
								methodRenamedName = methodSmellyBuscar.getNomeMetodo();
							}
						}
						if (!wasMethodRefactored(methodSmellyBuscar.getNomeClasse(), methodSmellyBuscar.getNomeMetodo(), methodRefactored)) {
							continue;
						}
						if (targetTefactoringTypes.contains(methodRefactored.getRefactoringType())) {
							MethodDataSmelly methodSmell = obterSmellPreviousCommit(methodRefactored.getCommit(), methodSmellyBuscar.getNomeClasse(), methodSmellyBuscar.getNomeMetodo(), typeSmell);
							if (methodSmell != null) {
								predictionRound.setCondition(true);
								predictionRound.setNull(methodSmell.getListaTecnicas());
								predictionRound.setNullAllExcept(methodSmell.getListaTecnicas());
								// writeTruePositiveToCsvFiles(methodRefactored, methodSmell);
							}
						}
						if (this.getMethodRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) {
							if ((dateCommitRenamed == null) || ( (dateCommitRenamed != null)
								&& (dateCommitRenamed.compareTo(methodRefactored.getCommitDate()) < 0)) ) {
								renamedMethod = true;
								dateCommitRenamed = methodRefactored.getCommitDate();
								classRenamedName = methodSmellyBuscar.getNomeClasse();
								methodRenamedName = extrairNomeMetodo(methodRefactored.getRightSide());
							}
						}
					}
					if (renamedMethod) {
						methodSmellyBuscar.setNomeClasse(classRenamedName);
						methodSmellyBuscar.setNomeMetodo(methodRenamedName);
					} else {
						dateCommitRenamed = null;
					}
				} while (renamedMethod && predictionRound.isAnyoneOutOfRound());
				
				predictionRound.setNullIfOutOfRound(methodSmellyBuscar.getListaTecnicas());
				if (predictionRound.isAnyoneOutOfRound()) {
					writeNegativeToCsvFiles(methodSmellyBuscar);
				}
				predictionRound.setFalseForAllOutOfRound();
				confusionMatrices.processPredictionRound(predictionRound);
			}
		}
	}
	
	private void computeTrueNegativeCommon(FilterSmellResult commitInitial,
			ArrayList<RefactoringData> listRefactoring, String smellType, HashSet<String> targetTefactoringTypes,
			ConfusionMatrixPredictors confusionMatrices) throws Exception {
		for (MethodDataSmelly methodNotSmelly : commitInitial.getMetodosNotSmelly()) {
			MethodDataSmelly methodBuscar = methodNotSmelly;
			boolean renamedMethod = false;
			boolean refactoredMethod = false;
			Date dateCommitRenamed = null;
			PredictionRound predictionRound = confusionMatrices.newRound();
			predictionRound.setDefaultCondition(false);
			do {
				renamedMethod = false;
				String classRenamedName = null;
				String methodRenamedName = null;
				for (RefactoringData methodRefactored : listRefactoring) {
					if ( (!this.getMethodRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) && (!targetTefactoringTypes.contains(methodRefactored.getRefactoringType())) ) {
						continue;
					}
					if (!methodRefactored.getNomeClasse().equals(methodBuscar.getNomeClasse())) {
						continue;
					}
					if (this.getClassRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) {
						if ((dateCommitRenamed == null) || ( (dateCommitRenamed != null)
								&& (dateCommitRenamed.compareTo(methodRefactored.getCommitDate()) < 0)) ) {
							renamedMethod = true;
							dateCommitRenamed = methodRefactored.getCommitDate();
							classRenamedName = methodRefactored.getRightSide();
							methodRenamedName = methodBuscar.getNomeMetodo();
						}
					}
					if (!wasMethodRefactored(methodBuscar.getNomeClasse(), methodBuscar.getNomeMetodo(), methodRefactored)) {
						continue;
					}
					if (targetTefactoringTypes.contains(methodRefactored.getRefactoringType())) {
						MethodDataSmelly methodSmell = obterSmellPreviousCommit(methodRefactored.getCommit(), methodBuscar.getNomeClasse(), methodBuscar.getNomeMetodo(), smellType);
						if (methodSmell != null) {
							predictionRound.setCondition(true);
							predictionRound.setNullIfOutOfRound(methodSmell.getListaTecnicas());
							// writeFalseNegativeToCsvFiles(methodRefactored, methodBuscar);
							refactoredMethod = true;
							break;
						}
					}
					if (this.getMethodRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) {
						if ((dateCommitRenamed == null) || (dateCommitRenamed != null
								&& dateCommitRenamed.compareTo(methodRefactored.getCommitDate()) < 0)) {
							renamedMethod = true;
							dateCommitRenamed = methodRefactored.getCommitDate();
							classRenamedName = methodBuscar.getNomeClasse();
							methodRenamedName = extrairNomeMetodo(methodRefactored.getRightSide());
						}
					} 
				}
				if (renamedMethod) {
					methodBuscar.setNomeClasse(classRenamedName);
					methodBuscar.setNomeMetodo(methodRenamedName);
				} else {
					dateCommitRenamed = null;
				}
			} while (renamedMethod && !refactoredMethod);
		

			if (!refactoredMethod) {
				predictionRound.setFalseForAllOutOfRound();
				writeNegativeToCsvFiles(methodBuscar);
			}
			predictionRound.setNullForAllOutOfRound();
			confusionMatrices.processPredictionRound(predictionRound);
		}
	}
	
	
	private void computeTruePositiveAndFalseNegative(ArrayList<RefactoringData> listRefactoring, String typeSmell,
			HashSet<String> targetTefactoringTypes, ConfusionMatrixPredictors confusionMatrices) throws Exception {
		for (RefactoringData refactoring : listRefactoring) {
			if ( (!this.getMethodRenameRefactoringTypes().contains(refactoring.getRefactoringType())) && (!targetTefactoringTypes.contains(refactoring.getRefactoringType())) ) {
				continue;
			}
			PredictionRound predictionRound = confusionMatrices.newRound();
			predictionRound.setCondition(true);
			if (targetTefactoringTypes.contains(refactoring.getRefactoringType())) {
				MethodDataSmelly classSmell = obterSmellPreviousCommit(refactoring.getCommit(), refactoring.getNomeClasse(), refactoring.getNomeMetodo(), typeSmell);
				if (classSmell != null) {
					predictionRound.setTrue(classSmell.getListaTecnicas());
					predictionRound.setFalseAllExcept(classSmell.getListaTecnicas());
					writeTruePositiveToCsvFiles(refactoring, classSmell);
				} else {
					predictionRound.setFalseForAllOutOfRound();
					writeFalsePositiveToCsvFiles(refactoring);
				}
			}
			predictionRound.setNullForAllOutOfRound();
			confusionMatrices.processPredictionRound(predictionRound);
		}
	}
	
	private void computeFalsePositive(FilterSmellResult commitInitial,
			ArrayList<RefactoringData> listRefactoring, String typeSmell, HashSet<String> targetTefactoringTypes,
			ConfusionMatrixPredictors confusionMatrices) throws Exception {
		for (MethodDataSmelly methodSmelly : commitInitial.getMetodosSmell()) {
			if (methodSmelly.getSmell().equals(typeSmell)) {
				MethodDataSmelly methodSmellyBuscar = methodSmelly;
				boolean renamedMethod = false;
				Date dateCommitRenamed = null;
				PredictionRound predictionRound = confusionMatrices.newRound();
				predictionRound.setDefaultCondition(false);
				do {
					renamedMethod = false;
					String classRenamedName = null;
					String methodRenamedName = null;
					for (RefactoringData methodRefactored : listRefactoring) {
						if ( (!this.getMethodRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) && (!targetTefactoringTypes.contains(methodRefactored.getRefactoringType())) ) {
							continue;
						}
						if (!methodRefactored.getNomeClasse().equals(methodSmellyBuscar.getNomeClasse())) {
							continue;
						}
						if (this.getClassRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) {
							if ((dateCommitRenamed == null) || ( (dateCommitRenamed != null)
									&& (dateCommitRenamed.compareTo(methodRefactored.getCommitDate()) < 0)) ) {
								renamedMethod = true;
								dateCommitRenamed = methodRefactored.getCommitDate();
								classRenamedName = methodRefactored.getRightSide();
								methodRenamedName = methodSmellyBuscar.getNomeMetodo();
							}
						}
						if (!wasMethodRefactored(methodSmellyBuscar.getNomeClasse(), methodSmellyBuscar.getNomeMetodo(), methodRefactored)) {
							continue;
						}
						if (targetTefactoringTypes.contains(methodRefactored.getRefactoringType())) {
							MethodDataSmelly methodSmell = obterSmellPreviousCommit(methodRefactored.getCommit(), methodSmellyBuscar.getNomeClasse(), methodSmellyBuscar.getNomeMetodo(), typeSmell);
							if (methodSmell != null) {
								predictionRound.setCondition(true);
								predictionRound.setNull(methodSmell.getListaTecnicas());
								// writeTruePositiveToCsvFiles(methodRefactored, methodSmell);
								// break;
							}
						}

						if (this.getMethodRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) {
							if ((dateCommitRenamed == null) || ( (dateCommitRenamed != null)
									&& (dateCommitRenamed.compareTo(methodRefactored.getCommitDate()) < 0)) ) {
								renamedMethod = true;
								dateCommitRenamed = methodRefactored.getCommitDate();
								classRenamedName = methodSmellyBuscar.getNomeClasse();
								methodRenamedName = extrairNomeMetodo(methodRefactored.getRightSide());
							}
						}
					}
					if (renamedMethod) {
						methodSmellyBuscar.setNomeClasse(classRenamedName);
						methodSmellyBuscar.setNomeMetodo(methodRenamedName);
					} else {
						dateCommitRenamed = null;
					}
				} while (renamedMethod && predictionRound.isAnyoneOutOfRound());
				
				if (predictionRound.isAnyoneOutOfRound()) {
					writeNegativeToCsvFiles(methodSmellyBuscar);
				}
				predictionRound.setTrueIfOutOfRound(methodSmellyBuscar.getListaTecnicas());
				predictionRound.setNullForAllOutOfRound();
				confusionMatrices.processPredictionRound(predictionRound);
			}
		}
	}
	
	
	
	public MethodDataSmelly obterSmellPreviousCommit(String commitId, String className, String methodName, String smellType) {
		MethodDataSmelly result = null;
		FilterSmellResult smellsPreviousCommit = this.commitSmell.obterSmellsPreviousCommit(commitId);
		if (smellsPreviousCommit != null) {
			for (MethodDataSmelly methodSmell : smellsPreviousCommit.getMetodosSmell()) {
				if (methodSmell.getSmell().equals(smellType)) {
					if ( (methodSmell.getNomeClasse().equals(className)) && methodSmell.getNomeMetodo().equals(methodSmell.getNomeMetodo()) ) {				
						result = methodSmell;
					}
				}
			}
		}
		return result;
	}

	private void writeNegativeToCsvFiles(MethodDataSmelly methodSmellyBuscar) {
		pmResultSmellRefactoredMethodsMessage.write(methodSmellyBuscar.getNomeClasse(),
			methodSmellyBuscar.getNomeMetodo(), methodSmellyBuscar.getSmell() != null ? methodSmellyBuscar.getSmell() : "",
			methodSmellyBuscar.getLinesOfCode(), methodSmellyBuscar.getComplexity(),
			methodSmellyBuscar.getEfferent(), methodSmellyBuscar.getNumberOfParameters(),
			methodSmellyBuscar.getListaTecnicas(), methodSmellyBuscar.getCommit(), "", "", "", "");
		pmResultSmellRefactoredMethods.write(methodSmellyBuscar.getNomeClasse(),
			methodSmellyBuscar.getNomeMetodo(), methodSmellyBuscar.getSmell() != null ? methodSmellyBuscar.getSmell() : "",
			methodSmellyBuscar.getLinesOfCode(), methodSmellyBuscar.getComplexity(),
			methodSmellyBuscar.getEfferent(), methodSmellyBuscar.getNumberOfParameters(),
			methodSmellyBuscar.getListaTecnicas(), methodSmellyBuscar.getCommit(), "", "", "");
		pmResultSmellRefactoredMethodsMachineLearning.write(methodSmellyBuscar.getClassDesignRole(),
			methodSmellyBuscar.getLinesOfCode(), methodSmellyBuscar.getComplexity(),
			methodSmellyBuscar.getEfferent(), methodSmellyBuscar.getNumberOfParameters(),
			"false", "");
	}

	private void writeTruePositiveToCsvFiles(RefactoringData methodRefactored, MethodDataSmelly methodSmell) {
		pmResultSmellRefactoredMethodsMessage.write(methodRefactored.getNomeClasse(),
			methodRefactored.getNomeMetodo(), methodRefactored.getSmell(),
			methodSmell.getLinesOfCode(), methodSmell.getComplexity(),
			methodSmell.getEfferent(), methodSmell.getNumberOfParameters(),
			methodRefactored.getListaTecnicas(), methodRefactored.getCommit(),
			methodRefactored.getRefactoringType(), methodRefactored.getLeftSide(),
			methodRefactored.getRightSide(), methodRefactored.getFullMessage());
		pmResultSmellRefactoredMethods.write(methodRefactored.getNomeClasse(),
			methodRefactored.getNomeMetodo(), methodRefactored.getSmell(),
			methodSmell.getLinesOfCode(), methodSmell.getComplexity(),
			methodSmell.getEfferent(), methodSmell.getNumberOfParameters(),
			methodRefactored.getListaTecnicas(), methodRefactored.getCommit(),
			methodRefactored.getRefactoringType(), methodRefactored.getLeftSide(),
			methodRefactored.getRightSide());
		pmResultSmellRefactoredMethodsMachineLearning.write(methodRefactored.getClassDesignRole(),
			methodRefactored.getLinesOfCode(), methodRefactored.getComplexity(),
			methodRefactored.getEfferent(), methodRefactored.getNumberOfParameters(),
			"true", methodRefactored.getRefactoringType());
		
	}

	private void writeFalseNegativeToCsvFiles(RefactoringData methodRefactored, MethodDataSmelly methodNotSmell) {
		pmResultSmellRefactoredMethodsMessage.write(methodRefactored.getNomeClasse(),
				methodRefactored.getNomeMetodo(), methodRefactored.getSmell() != null ? methodRefactored.getSmell() : "",
				methodNotSmell.getLinesOfCode(), methodNotSmell.getComplexity(),
				methodNotSmell.getEfferent(), methodNotSmell.getNumberOfParameters(),
				methodRefactored.getListaTecnicas(), methodRefactored.getCommit(),
				methodRefactored.getRefactoringType(), methodRefactored.getLeftSide(),
				methodRefactored.getRightSide(), methodRefactored.getFullMessage());
		pmResultSmellRefactoredMethods.write(methodRefactored.getNomeClasse(),
				methodRefactored.getNomeMetodo(), methodRefactored.getSmell() != null ? methodRefactored.getSmell() : "",
				methodNotSmell.getLinesOfCode(), methodNotSmell.getComplexity(),
				methodNotSmell.getEfferent(), methodNotSmell.getNumberOfParameters(),
				methodRefactored.getListaTecnicas(), methodRefactored.getCommit(),
				methodRefactored.getRefactoringType(), methodRefactored.getLeftSide(),
				methodRefactored.getRightSide());
		pmResultSmellRefactoredMethodsMachineLearning.write(methodRefactored.getClassDesignRole(),
				methodNotSmell.getLinesOfCode(), methodNotSmell.getComplexity(),
				methodNotSmell.getEfferent(), methodNotSmell.getNumberOfParameters(),
				"true", methodRefactored.getRefactoringType());
	}

	private void writeFalsePositiveToCsvFiles(RefactoringData refactoring) {
		pmResultSmellRefactoredMethodsMessage.write(refactoring.getNomeClasse(),
				refactoring.getNomeMetodo(), refactoring.getSmell() != null ? refactoring.getSmell() : "",
				refactoring.getLinesOfCode(), refactoring.getComplexity(),
				refactoring.getEfferent(), refactoring.getNumberOfParameters(),
				refactoring.getListaTecnicas(), refactoring.getCommit(), "", "", "", "");
			pmResultSmellRefactoredMethods.write(refactoring.getNomeClasse(),
				refactoring.getNomeMetodo(), refactoring.getSmell() != null ? refactoring.getSmell() : "",
				refactoring.getLinesOfCode(), refactoring.getComplexity(),
				refactoring.getEfferent(), refactoring.getNumberOfParameters(),
				refactoring.getListaTecnicas(), refactoring.getCommit(), "", "", "");
			pmResultSmellRefactoredMethodsMachineLearning.write(refactoring.getClassDesignRole(),
				refactoring.getLinesOfCode(), refactoring.getComplexity(),
				refactoring.getEfferent(), refactoring.getNumberOfParameters(),
				"false", "");
	}
	
	
	private static int countPositivePredictionForTechnique(FilterSmellResult commitInitial, String smellType, String technique) {
		int positivePrediction = 0; 
		for (MethodDataSmelly methodSmelly : commitInitial.getMetodosSmell()) {
			if (methodSmelly.getSmell().contains(smellType)) {
				if (methodSmelly.getListaTecnicas().contains(technique)) {
					positivePrediction++;
				}
			}
		}
		return positivePrediction;
	}
	
	
	
	
	
	
	private void evaluateSmellChangeParameters(FilterSmellResult commitInitial,
			ArrayList<RefactoringData> listRefactoring, String typeSmell, HashSet<String> targetTefactoringTypes) throws Exception {

		ConfusionMatrixPredictors confusionMatrices = new ConfusionMatrixPredictors(typeSmell + " " + targetTefactoringTypes.toString(), this.commitSmell.getTechniquesThresholds().keySet());

		Integer ignoredPredictionCount = 0;
		
		computeNegativePredictionsForChangeParameters(commitInitial, listRefactoring, typeSmell, targetTefactoringTypes,
				confusionMatrices);

		computePositivePredictionsForChangeParameters(commitInitial, listRefactoring, typeSmell, targetTefactoringTypes,
				confusionMatrices, ignoredPredictionCount);

		
		int realPositive = SmellRefactoredManager.countRealPositive(refactoringsCounter, targetTefactoringTypes);
		confusionMatrices.setValidationRealPositive(realPositive);
		for (String technique : this.commitSmell.getTechniquesThresholds().keySet()) {
			Integer positivePredictionExpected = countPositivePredictionForTechnique(commitInitial, typeSmell, technique);
			confusionMatrices.setValidationPositivePrediction(technique, positivePredictionExpected);
		}
		
		pmResultEvaluationMethods.write("");
		confusionMatrices.writeToCsvFile(pmResultEvaluationMethods);
		
	}

	private void computePositivePredictionsForChangeParameters(FilterSmellResult commitInitial,
			ArrayList<RefactoringData> listRefactoring, String typeSmell, HashSet<String> targetTefactoringTypes,
			ConfusionMatrixPredictors confusionMatrices,
			Integer ignoredPredictionCount) throws Exception {
		for (MethodDataSmelly methodSmelly : commitInitial.getMetodosSmell()) {
			if (methodSmelly.getSmell().equals(typeSmell)) {
				MethodDataSmelly methodSmellyBuscar = methodSmelly;
				boolean renamedMethod = false;
				Date dateCommitRenamed = null;
				PredictionRound predictionRound = confusionMatrices.newRound();
				predictionRound.setDefaultCondition(false);
				do {
					renamedMethod = false;
					String methodRenamedName = null;
					for (RefactoringData methodRefactored : listRefactoring) {
						if ( (!this.getMethodRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) && (!targetTefactoringTypes.contains(methodRefactored.getRefactoringType())) ) {
							continue;
						}
						if (!wasMethodRefactored(methodSmellyBuscar.getNomeClasse(), methodSmellyBuscar.getNomeMetodo(), methodRefactored)) {
							continue;
						}
						if ( (targetTefactoringTypes.contains(methodRefactored.getRefactoringType())) 
								&& methodRefactored.getLeftSide().contains(methodSmellyBuscar.getNomeMetodo())
								&& methodRefactored.getInvolvedClassesBefore()
										.contains(methodSmellyBuscar.getNomeClasse())) {
							if ((dateCommitRenamed == null) || (dateCommitRenamed != null
									&& dateCommitRenamed.compareTo(methodRefactored.getCommitDate()) < 0)) {
								renamedMethod = true;
								dateCommitRenamed = methodRefactored.getCommitDate();
								methodRenamedName = extrairNomeMetodo(methodRefactored.getRightSide());
								if (countParameters(methodRefactored.getRightSide()) < countParameters(
										methodRefactored.getLeftSide())) {
									MethodDataSmelly methodSmell = obterSmellPreviousCommit(methodRefactored.getCommit(), methodSmellyBuscar.getNomeClasse(), methodSmellyBuscar.getNomeMetodo(), typeSmell);
									if (methodSmell != null) {
										predictionRound.setCondition(true);
										predictionRound.setTrue(methodSmellyBuscar.getListaTecnicas());
										predictionRound.setFalseAllExcept(methodSmellyBuscar.getListaTecnicas());
										writeTruePositiveToCsvFiles(methodRefactored, methodSmell);
									}
								}
							}
						}
						if (this.getMethodRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) {
							if ((dateCommitRenamed == null) || (dateCommitRenamed != null
									&& dateCommitRenamed.compareTo(methodRefactored.getCommitDate()) < 0)) {
								renamedMethod = true;
								dateCommitRenamed = methodRefactored.getCommitDate();
								methodRenamedName = extrairNomeMetodo(methodRefactored.getRightSide());
							}
						}
					}
					if (renamedMethod) {
						methodSmellyBuscar.setNomeMetodo(methodRenamedName);
					} else {
						dateCommitRenamed = null;
					}
				} while (renamedMethod && predictionRound.isAnyoneOutOfRound());

				predictionRound.setTrue(methodSmellyBuscar.getListaTecnicas());
				predictionRound.setFalseAllExcept(methodSmellyBuscar.getListaTecnicas());
				if (predictionRound.isAnyoneOutOfRound()) {
					writeNegativeToCsvFiles(methodSmellyBuscar);
				}
				confusionMatrices.processPredictionRound(predictionRound);
				
			}
		}
	}

	private void computeNegativePredictionsForChangeParameters(FilterSmellResult commitInitial,
			ArrayList<RefactoringData> listRefactoring, String smellType, HashSet<String> targetTefactoringTypes,
			ConfusionMatrixPredictors confusionMatrices) throws Exception {
		for (MethodDataSmelly methodNotSmelly : commitInitial.getMetodosNotSmelly()) {
			MethodDataSmelly methodBuscar = methodNotSmelly;
			boolean renamedMethod = false;
			boolean refactoredMethod = false;
			Date dateCommitRenamed = null;
			PredictionRound predictionRound = confusionMatrices.newRound();
			predictionRound.setDefaultCondition(false);
			do {
				renamedMethod = false;
				String methodRenamedName = null;
				for (RefactoringData methodRefactored : listRefactoring) {
					if ( (!this.getMethodRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) && (!targetTefactoringTypes.contains(methodRefactored.getRefactoringType())) ) {
						continue;
					}
					if (!wasMethodRefactored(methodBuscar.getNomeClasse(), methodBuscar.getNomeMetodo(), methodRefactored)) {
						continue;
					}
					if (targetTefactoringTypes.contains(methodRefactored.getRefactoringType())) {
						if ((dateCommitRenamed == null) || (dateCommitRenamed != null
								&& dateCommitRenamed.compareTo(methodRefactored.getCommitDate()) < 0)) {
							if (countParameters(methodRefactored.getRightSide()) < countParameters(
									methodRefactored.getLeftSide())) {
								MethodDataSmelly methodSmell = obterSmellPreviousCommit(methodRefactored.getCommit(), methodBuscar.getNomeClasse(), methodBuscar.getNomeMetodo(), smellType);
								if (methodSmell != null) {
									predictionRound.setCondition(true);
									predictionRound.setTrue(methodSmell.getListaTecnicas());
									predictionRound.setFalseAllExcept(methodSmell.getListaTecnicas());
									refactoredMethod = true;
									writeFalseNegativeToCsvFiles(methodRefactored, methodBuscar);
									break;
								}
							}
						}
							
					}
					if (this.getMethodRenameRefactoringTypes().contains(methodRefactored.getRefactoringType())) {
						if ((dateCommitRenamed == null) || (dateCommitRenamed != null
							&& dateCommitRenamed.compareTo(methodRefactored.getCommitDate()) < 0)) {
						renamedMethod = true;
						dateCommitRenamed = methodRefactored.getCommitDate();
						methodRenamedName = extrairNomeMetodo(methodRefactored.getRightSide());
						}
					}
				}
				if (renamedMethod) {
					methodBuscar.setNomeMetodo(methodRenamedName);
				} else {
					dateCommitRenamed = null;
				}
			} while (renamedMethod && !refactoredMethod);
		
			if (!refactoredMethod) {
				writeNegativeToCsvFiles(methodBuscar);
			}
			predictionRound.setFalseForAllOutOfRound();
			confusionMatrices.processPredictionRound(predictionRound);
		}
	}
	
	public static String extrairNomeMetodo(String rightSide) {
		int methodNameEnd = rightSide.indexOf("(");
		String partialMethodName = rightSide.substring(0, methodNameEnd);
		int methodNameBegin = partialMethodName.lastIndexOf(" ") + 1;
		return partialMethodName.substring(methodNameBegin);
	}

	private int countParameters(String metodo) {
		int countParams = 0;
		if (metodo.contains(",")) {
			countParams = 1;
			for (int i = 0; i < metodo.length(); i++) {
				if (metodo.charAt(i) == ',') {
					countParams++;
				}
			}
		} else {
			int posPrimeiroParenteses = metodo.indexOf("(");
			int posUltimoParenteses = metodo.indexOf(")");
			for (int i = posPrimeiroParenteses + 1; i < posUltimoParenteses - 1; i++) {
				if (metodo.charAt(i) != ' ' && metodo.charAt(i) != ')') {
					countParams++;
					break;
				}
			}
		}
		return countParams;
	}
	
	
	private CommitData getNextCommit(String commitId) {
		CommitData nextCommit = null;
		for (CommitData commit : commitsMergedIntoMaster) {
			if (commit.getPrevious() != null) {
				if (commit.getPrevious().getId().equals(commitId)) {
					nextCommit = commit;
					break;
				}
			}
		}
		return nextCommit;
	}
	

	private boolean wasMethodRefactored(String className, String methodName, RefactoringData refactoring) {
		boolean isClassInvolvementBefore = refactoring.getInvolvedClassesBefore().contains(className);
		boolean isClassInvolvementAfter  = refactoring.getInvolvedClassesAfter().contains(className);
		boolean isClassInvolvement  = (isClassInvolvementBefore || isClassInvolvementAfter);
		boolean isClassSameName = refactoring.getNomeClasse().equals(className);

		boolean isMethodLeftSide = refactoring.getLeftSide().contains(methodName);
		boolean isMethodRightSide = refactoring.getRightSide().contains(methodName);
		boolean isMethodSide = (isMethodLeftSide || isMethodRightSide);
		boolean isMethodSameName = refactoring.getNomeMetodo().equals(methodName);

		boolean isSameClass = (isClassSameName);
		boolean isSameMethod = (isMethodSameName);
		
		return (isSameClass && isSameMethod);
	}
	

	
}