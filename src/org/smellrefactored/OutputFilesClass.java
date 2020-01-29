package org.smellrefactored;

import org.designroleminer.smelldetector.model.ClassDataSmelly;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.persistence.csv.CSVFile;

public class OutputFilesClass {

	String baseFileName;
	
	PersistenceMechanism pmResultSmellRefactoredClasses;
	PersistenceMechanism pmResultSmellRefactoredClassesMessage;
	PersistenceMechanism pmResultSmellRefactoredClassesMachineLearning;

	public OutputFilesClass(String baseFileName) {
		
		this.baseFileName = baseFileName;
		
		pmResultSmellRefactoredClasses = new CSVFile(this.baseFileName + "-smellRefactored-classes.csv", false);
		pmResultSmellRefactoredClassesMessage = new CSVFile(this.baseFileName + "-smellRefactored-classes-message.csv", false);
		pmResultSmellRefactoredClassesMachineLearning = new CSVFile(this.baseFileName + "-smellRefactored-classes-machineLearning.csv", false);
	}
	
	public void writeHeaders() {
		pmResultSmellRefactoredClassesMessage.write(
				"Class"
				, "Smell"
				, "CLOC"
				, "Tecnicas"
				, "Commit"
				, "Refactoring"
				, "Left Side"
				, "Right Side"
				, "Full Message"
				);
		pmResultSmellRefactoredClasses.write(
				"Class"
				, "Smell"
				, "CLOC"
				, "Tecnicas"
				, "Commit"
				, "Refactoring"
				, "Left Side"
				, "Right Side"
				);
		pmResultSmellRefactoredClassesMachineLearning.write(
				"commitId"
				, "filePath"
				, "className"
				, "DesignRole"
				, "CLOC"
				, "isRefactoring"
				, "Refactoring"
				);
	}

	
	public void writeTruePositiveToCsvFiles(RefactoringData refactoring, ClassDataSmelly classSmell) throws Exception {
		pmResultSmellRefactoredClassesMessage.write(
				refactoring.getNomeClasse()
				, classSmell.getSmell()
				, classSmell.getLinesOfCode()
				, classSmell.getListaTecnicas()
				, refactoring.getCommitId()
				, refactoring.getRefactoringType()
				, refactoring.getLeftSide()
				, refactoring.getRightSide()
				, refactoring.getFullMessage()
				);
		pmResultSmellRefactoredClasses.write(
				refactoring.getNomeClasse()
				, classSmell.getSmell()
				, classSmell.getLinesOfCode()
				, classSmell.getListaTecnicas()
				, refactoring.getCommitId()
				, refactoring.getRefactoringType()
				, refactoring.getLeftSide()
				, refactoring.getRightSide()
				);
		pmResultSmellRefactoredClassesMachineLearning.write(
				classSmell.getCommit()
				, refactoring.getFileNameAfter()
				, refactoring.getNomeClasse()
				, refactoring.getClassDesignRole()
				, classSmell.getLinesOfCode()
				, "true"
				, refactoring.getRefactoringType()
				);
	}

	public void writeFalseNegativeToCsvFiles(RefactoringData refactoring, ClassDataSmelly classNotSmell) throws Exception {
		pmResultSmellRefactoredClassesMessage.write(
				refactoring.getNomeClasse()
				, (classNotSmell.getSmell() != null ? classNotSmell.getSmell() : "")
				, classNotSmell.getLinesOfCode()
				, classNotSmell.getListaTecnicas()
				, refactoring.getCommitId()
				, refactoring.getRefactoringType()
				, refactoring.getLeftSide()
				, refactoring.getRightSide()
				, refactoring.getFullMessage()
				);
		pmResultSmellRefactoredClasses.write(
				refactoring.getNomeClasse()
				, (classNotSmell.getSmell() != null ? classNotSmell.getSmell() : "")
				, classNotSmell.getLinesOfCode()
				, classNotSmell.getListaTecnicas()
				, refactoring.getCommitId()
				, refactoring.getRefactoringType()
				, refactoring.getLeftSide()
				, refactoring.getRightSide()
				);
		pmResultSmellRefactoredClassesMachineLearning.write(
				classNotSmell.getCommit()
				, refactoring.getFileNameAfter()
				, refactoring.getNomeClasse()
				, refactoring.getClassDesignRole()
				, classNotSmell.getLinesOfCode()
				, "true"
				, refactoring.getRefactoringType()
				);
	}	

	public void writeFalsePositiveToCsvFiles(RefactoringData refactoring, ClassDataSmelly classNotSmell) throws Exception {
		pmResultSmellRefactoredClassesMessage.write(
				refactoring.getNomeClasse()
				, classNotSmell.getSmell()
				, classNotSmell.getLinesOfCode()
				, classNotSmell.getListaTecnicas()
				, refactoring.getCommitId()
				, ""
				, ""
				, ""
				, ""
				);
		pmResultSmellRefactoredClasses.write(
				refactoring.getNomeClasse()
				, classNotSmell.getSmell()
				, classNotSmell.getLinesOfCode()
				, classNotSmell.getListaTecnicas()
				, classNotSmell.getCommit()
				, ""
				, ""
				, ""
				);
		pmResultSmellRefactoredClassesMachineLearning.write(
				classNotSmell.getCommit()
				, refactoring.getFileNameAfter()
				, refactoring.getNomeClasse()
				, refactoring.getClassDesignRole()
				, classNotSmell.getLinesOfCode()
				, "false"
				, ""
				);
	}
	
	public void writeNegativeToCsvFiles(ClassDataSmelly classBuscar) {
		pmResultSmellRefactoredClassesMessage.write(
				classBuscar.getNomeClasse()
				, classBuscar.getSmell()
				, classBuscar.getLinesOfCode()
				, classBuscar.getListaTecnicas()
				, classBuscar.getCommit()
				, ""
				, ""
				, ""
				, ""
				);
		pmResultSmellRefactoredClasses.write(
				classBuscar.getNomeClasse()
				, classBuscar.getSmell()
				, classBuscar.getLinesOfCode()
				, classBuscar.getListaTecnicas()
				, classBuscar.getCommit()
				, ""
				, ""
				, ""
				);
		pmResultSmellRefactoredClassesMachineLearning.write(
				classBuscar.getCommit() 
				, classBuscar.getDiretorioDaClasse()
				, classBuscar.getNomeClasse()
				, classBuscar.getClassDesignRole()
				, classBuscar.getLinesOfCode()
				, "false"
				, ""
				);
	}
	
	
	public void close() {
		pmResultSmellRefactoredClassesMessage.close();
		pmResultSmellRefactoredClasses.close();
		pmResultSmellRefactoredClassesMachineLearning.close();
		
	}
	
	
}