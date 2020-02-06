package org.smellrefactored.classes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.designroleminer.smelldetector.model.ClassDataSmelly;

import com.opencsv.CSVWriter;

public class FileOutputForExternalAnalysisClass {
	
	private String[] refactoringTypes;
	private String[] techniques;
	private String resultBaseFileName;
	
	private HashSet<String> processedCommits = new HashSet<String>();
	
	private FileWriter fileHandler;
	private CSVWriter csv;

	/*
	Id�ia: Essa classe poderia receber, primeiro, a lista de refatora��es e organiz�-las por commit arquivo e classe numa lista interna
	       Ap�s, receberia a lista de smells e a acomodaria na lista interna
	       Ap�s, receberia a lista de not smells e a acomodaria na lista interna
	       Ap�s, solicitaria e processaria os smells para os commits originados com refatora��o que n�o tivessem recebido smells e not smells
	       Por �ltimo, gerar o arquivo e a matr�z de confus�o, ou repassar, melhor, o arquivo para um gerador de matriz de confus�o
    */
	
	public FileOutputForExternalAnalysisClass(String[] refactoringTypes, String[] techniques, String resultBaseFileName) throws IOException {
		this.refactoringTypes = refactoringTypes;
		this.techniques = techniques;
		this.resultBaseFileName = resultBaseFileName;

		FileWriter fileHandler = new FileWriter(this.resultBaseFileName + "-classes-forExternalAnalises.csv");
		csv = new CSVWriter(fileHandler);
	}
	
	public void writeCsvHeader() {
		ArrayList<String> header = new ArrayList<String>();
		header.add("commitId");
		header.add("designRole");
		header.add("filePath");
		header.add("className");
		header.add("cloc");
		for (String technique : techniques) {
			header.add(technique);
		}
		header.add("refactored");
		for (String refactoringType : refactoringTypes) {
			header.add(refactoringType);
		}
		csv.writeNext((String[]) header.toArray());
	}

	public void writeCsvLine(ClassDataSmelly classDataSmelly, String[] refactorings) {
		if (!processedCommits.contains(classDataSmelly.getCommit())) {
			processedCommits.add(classDataSmelly.getCommit());
			ArrayList<String> line = new ArrayList<String>();
			line.add(classDataSmelly.getCommit());
			line.add(classDataSmelly.getClassDesignRole());
			line.add(classDataSmelly.getDiretorioDaClasse());
			line.add(classDataSmelly.getNomeClasse());
			line.add(Integer.toString(classDataSmelly.getLinesOfCode()));
			for (String technique : techniques) {
				line.add( (classDataSmelly.getListaTecnicas().contains(technique)) ? "T" :  "F");
			}
			line.add( ((refactorings != null) && (refactorings.length>0) )  ? "T" :  "F");
			for (String refactoringType : refactoringTypes) {
				line.add( Arrays.asList(refactorings).contains(refactoringType) ? "T" :  "F");
			}
			csv.writeNext((String[]) line.toArray());
		}
	}
	
	public void close() throws IOException {
		csv.close();
		fileHandler.close();
	}
}
