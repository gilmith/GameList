package gamelist.controller;

import java.util.ArrayList;

import gamelist.file.FileInspector;

public class FolderController {
	
	private String folder;
	private ArrayList<String> nombres, ficheros;
	
	public FolderController(String folder) {
		this.folder = folder;
		FileInspector fi = new FileInspector(folder);
		nombres = fi.getGameListStorage();
		ficheros = fi.getGameFileName();
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public ArrayList<String> getNombres() {
		return nombres;
	}

	public void setNombres(ArrayList<String> nombres) {
		this.nombres = nombres;
	}

	public ArrayList<String> getFicheros() {
		return ficheros;
	}

	public void setFicheros(ArrayList<String> ficheros) {
		this.ficheros = ficheros;
	}
	
	public String getAutoExplore() {
		StringBuilder sb = new StringBuilder();
		for(String nombre : nombres) {
			sb.append(nombre + "\n");
		}
		return sb.toString();
	}

	
	

}
