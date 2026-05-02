package asp.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import asp.modelo.Aspirante;
import asp.modelo.AspiranteDAO;
import asp.modelo.ProgAcad;
import asp.modelo.ProgAcadDAO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("asp")
@RequestScoped
public class AspiranteBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Aspirante dto = new Aspirante();
	private ArrayList<Aspirante> listaAs = AspiranteDAO.lista_A;
	private ArrayList<ProgAcad> listaPa = ProgAcadDAO.lista_P;

	public AspiranteBean() {
		ProgAcadDAO.cargaDatos();
	}

	public Aspirante getDto() {
		return dto;
	}

	public void setDto(Aspirante dto) {
		this.dto = dto;
	}

	public ArrayList<Aspirante> getListaAs() {
		return listaAs;
	}

	public void setListaAs(ArrayList<Aspirante> listaAs) {
		this.listaAs = listaAs;
	}

	public ArrayList<ProgAcad> getListaPa() {
		return listaPa;
	}

	public void setListaPa(ArrayList<ProgAcad> listaPa) {
		this.listaPa = listaPa;
	}

	public void registrar() {
		int idx = dto.getPro_acad().getCod();
		// Validar que se haya seleccionado un programa válido
		if (idx < 0 || idx >= listaPa.size()) {
			System.out.println("Programa académico no válido, no se registró el aspirante.");
			return;
		}
		dto.setFecha_reg(LocalDate.now());
		dto.setPro_acad(listaPa.get(idx));
		listaAs.add(dto);
		System.out.println("Se registró: " + dto.toString());
		// Resetear el dto para el siguiente registro
		dto = new Aspirante();
	}

}
