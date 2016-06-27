package br.edu.ifpr.projeto.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class MensalidadesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Integer> mensalidades;

	public MensalidadesBean() {
		mensalidades = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			mensalidades.add(i);
		}
	}

	public List<Integer> getMensalidades() {
		return mensalidades;
	}

	public void enviar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage("E-mail de confirmação de pagamento enviado !!"));
	}
}
