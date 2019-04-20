/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import modelo.Dal.DaoUsuario;
import modelo.Entidades.Usr;

/**
 * REST Web Service
 *
 * @author carlos
 */
@Path("login")
public class LoginResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of LoginResource
     */
    public LoginResource() {
    }

    /**
     * Retrieves representation of an instance of servicios.LoginResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usr getJson(@QueryParam("usuario") String user, @QueryParam("clave") String clave) {
       Usr usuario = new Usr();
        try {
            DaoUsuario du = new DaoUsuario();
            usuario = du.login(user, clave);
            return usuario;
        } catch (Exception e) {
            return null;
        }
           
    }


    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
