package test;

import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

public class ParlamentarTest {

    @Test
    public void callCreateParalementarAdminView() {
        Result result = callAction(
          controllers.routes.ref.Administrador.createParlamentar()
        );
        assertThat(status(result)).isEqualTo(OK);
        assertThat(contentType(result)).isEqualTo("text/html");
        assertThat(charset(result)).isEqualTo("utf-8");
        //assertThat(contentAsString(result)).contains();
    }
    
    @Test
    public void callListarParalementarAdminView() {
        Result result = callAction(
          controllers.routes.ref.Administrador.listarParlamentar()
        );
        assertThat(status(result)).isEqualTo(OK);
        assertThat(contentType(result)).isEqualTo("text/html");
        assertThat(charset(result)).isEqualTo("utf-8");
        //assertThat(contentAsString(result)).contains();
    }
    
    @Test
    public void verifyRoutesParlamentar() {
      Result result;
      result = routeAndCall(fakeRequest(GET, "/administrador/parlamentar/criar"));
      assertThat(result).isNull();
      result = routeAndCall(fakeRequest(GET, "/administrador/parlamentar/listar"));
      assertThat(result).isNull();
      result = routeAndCall(fakeRequest(GET, "/administrador/parlamentar/editar/1"));
      assertThat(result).isNull();
      result = routeAndCall(fakeRequest(GET, "/administrador/parlamentar/doRemover/1"));
      assertThat(result).isNull();
    }

}