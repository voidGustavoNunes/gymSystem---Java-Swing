/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Gustavo
 */
public class ConexaoAjuda {

    public void conectar(String cpfRecebido, String nomeRecebido, String emailRecebido, String duvidaRecebida) {

        String host = "smtp-mail.outlook.com"; // 
        String username = "aplicacaoJavaAcademy@outlook.com"; // email destinatario (e remetente)
        String password = "Admin@rps813"; // senha
        int port = 587; // Porta SMTP (normalmente 587 ou 465)

        SimpleEmail email = new SimpleEmail();

        email.setHostName(host);

        email.setSmtpPort(port);

        email.setAuthenticator(
                new DefaultAuthenticator(username, password));
        email.setStartTLSRequired(true); // Habilita o uso do TLS
        //email.setSSLOnConnect(true);

        try {
            email.setFrom(username);
            email.setSubject("Dúvida Projeto Academy"); //asssunto
            email.setMsg("\n CPF DO REMETENTE: " + cpfRecebido + ";\n NOME DO REMETENTE: " + nomeRecebido + ";\n EMAIL DO REMETENTE: " + emailRecebido
                    + ";\n DUVIDA: " + duvidaRecebida + ".");
            email.addTo(username);
            email.send();
            System.out.println("\n\n EMAIL ENVIADO COM SUCESSO! \n\n");
            
            
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public ConexaoAjuda() {
    }

}
