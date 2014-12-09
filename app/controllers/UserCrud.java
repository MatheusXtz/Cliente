
package controllers;

import java.util.List;

import models.Cliente;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class UserCrud extends Controller {

	private static final Form<Cliente> userForm = Form.form(Cliente.class);

	public static Result listarUser() {
		List<Cliente> users = Cliente.find.findList();
		return ok(views.html.curso.render(users));
	}
	public static Result visu() {
		List<Cliente> users = Cliente.find.findList();
		return ok(views.html.visu.render(users));
	}
	public static Result gravar() {
		Form<Cliente> form = userForm.bindFromRequest();

		if (form.hasErrors()) {
			flash("erro", "Foram identificados erros no cadastro!");
			return redirect(routes.UserCrud.listarUser());
		}
		Cliente user = form.get();
		user.save();

		flash("sucesso", "Dados Gravados com sucesso");
		return redirect(routes.UserCrud.listarUser());
	}
	
		public static Result detalhar(Long id) {
			Form<Cliente> userForm = Form.form(Cliente.class).fill(Cliente.find.byId(id));
			return ok(views.html.alterarCurso.render(id, userForm));
		}

		public static Result alterar(Long id) {
			Form.form(Cliente.class).fill(Cliente.find.byId(id));

			Form<Cliente> alterarForm = Form.form(Cliente.class).bindFromRequest();
			if (alterarForm.hasErrors()) {
				return badRequest(views.html.alterarCurso.render(id, alterarForm));
			}
			alterarForm.get().update(id);
			flash("sucesso", "Curso " + alterarForm.get().getNome()
					+ " alterado com sucesso");

			return redirect(routes.UserCrud.listarUser());
		}

		public static Result remover(Long id) {
			Cliente.find.ref(id).delete();
			flash("sucesso", "Curso removido com sucesso");
			return listarUser();
		}
	
}
