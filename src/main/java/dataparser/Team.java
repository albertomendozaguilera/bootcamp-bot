package dataparser;

import java.util.List;

public class Team {

	private int id;
	private String name;
	private List<Activity> actividades;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Activity> getactividades() {
		return actividades;
	}

	public Activity getActivityByIndex(int id) {
		return actividades.get(id);
	}

	public void setactividades(List<Activity> actividades) {
		this.actividades = actividades;
	}

	public int getTotalPuntos() {
		int puntos = 0;
		for (int i = 0; i < actividades.size(); i++) {
			puntos += actividades.get(i).getPuntos();
		}
		return puntos;
	}

	@Override
	public String toString() {
		return "{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", actividades=" + actividades + '}';
	}
}
