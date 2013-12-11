package teste;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.codec.digest.DigestUtils;

import com.marcafut.business.model.UsuarioED;
import com.marcafut.business.service.UsuarioRN;
import com.marcafut.controller.LoginMB;

@Singleton
public class TesteRN {

    @PersistenceContext
    EntityManager em;

    @Inject
    UsuarioRN usuarioService;

    @Inject
    LoginMB loginMB;

    @PostConstruct
    public void constroi() {
        System.out.println(">>>>>> !!! DEBUG !!! <<<<<<");  

        UsuarioED usuarioED = new UsuarioED();
        usuarioED.setId(99999999L);
        usuarioED.setNome("Luiz Henrique");
        usuarioED.setSobrenome("Araujo Mello");
        usuarioED.setApelido("Titi");
        usuarioED.setDataNascimento(Calendar.getInstance());
        usuarioED.setEmail("lhamello@gmail.com");
        usuarioED.setSenha(DigestUtils.sha512Hex("123456"));
        // usuarioED.setSenha("12345");

        Query query = em
                .createNativeQuery("insert into usuarios (id, nome, sobrenome, apelido, email, senha) values (?1, ?2, ?3, ?4, ?6, ?7)");
        query.setParameter(1, usuarioED.getId());
        query.setParameter(2, usuarioED.getNome());
        query.setParameter(3, usuarioED.getSobrenome());
        query.setParameter(4, usuarioED.getApelido());
        query.setParameter(6, usuarioED.getEmail());
        query.setParameter(7, usuarioED.getSenha());

        query.executeUpdate();

        System.out.println(">>>>>> !!! DEBUG !!! <<<<<<");
        System.out.println(usuarioED);

        // UsuarioED ed = new UsuarioED();
        // ed.setEmail("lhamello@gmail.com");
        // ed.setSenha("12345");
        //
        // loginMB.setUsuarioED(ed);
        // loginMB.efetuaLogin();
        // System.out.println(">>>>>> !!! LOGIN EXECUTADO COM SUCESSO !!! <<<<<<");
        //
        // ed.setEmail("lhamello@procergs.rs.gov.br");
        // ed.setSenha("12345");
        //
        // loginMB.setUsuarioED(ed);
        // loginMB.efetuaLogin();
    }

    @Schedule(hour = "*", minute = "*", second = "*/120", persistent = false)
    public void teste() {
        UsuarioED ed = usuarioService.consultarPorId(99999999L);
        System.out.println(ed);
    }

}
