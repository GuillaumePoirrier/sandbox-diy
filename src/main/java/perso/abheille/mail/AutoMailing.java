package perso.abheille.mail;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class AutoMailing {

    public static void main(String typeOfMail, String mail, String nomCommission, String libelle, Timestamp dateHeure, String description, String lieu, int duree, int nbPostes) {
        String to;
        String from = "tea.hei.automailing@gmail.com";
        String maildelAutomailing = "tea.hei.automailing@gmail.com";
        String motdepasse = "admintea";

        String dateHeureFormatee = formatDateHeure(dateHeure);


        if (typeOfMail.equals("contactUs")) {
            to = "tea@hei.fr";
        } else {
            to = mail;
        }

        Properties props = new Properties();//Propriétés de connexion au serveur Gmail
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");


        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        try {
            MimeMessage mess = new MimeMessage(session);

            mess.setFrom(new InternetAddress(from));

            mess.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            switch (typeOfMail) {

                case "evenementValide":
                    mess.setSubject("Evènement validé par l'Administrateur");
                    String messageVal =
                            "<html>" +
                                    "<body bgcolor=\"#ffffff\" style=\"padding-left:20px;padding-right:20px\"\">"
                                    + "<div style=\"background-color: #cc0000;margin-top:20px; color:white; border-radius: 4px;padding:15px;\"><center><strong>"
                                    + "<center><font size=\"5\">Bonjour " + nomCommission + ", votre évènement a été validé.</font></center>"
                                    + "</div>"
                                    + "<div><p style=\"border:1px solid black;padding:10px;border-radius:3px;\">"
                                    + "<u>Résumé de l'évènement :</u> " + "</br>"
                                    + "Date et heure : " + dateHeureFormatee + "</br>"
                                    + "Libellé : " + libelle + "</br>"
                                    + "Description : " + description + "</br>"
                                    + "Lieu : " + lieu + "</br>"
                                    + "Durée : " + duree + " h</br>"
                                    + "Nombre de postes : " + nbPostes + " étudiants</br></br>"
                                    + "</p></div>"
                                    + "<div><center><strong>Si ce message ne vous est pas destiné, ou pour un quelconque problème, contacter nous sur <a href=\"mailto:tea@hei.fr\">tea@hei.fr</a> ." + "</br>"
                                    + "Ne répondez pas à ce message s'il vous plait.</strong></center></div>"
                                    + "<center><img height=\"70px\" src=\"http://www.hei.fr/wp-content/uploads/2017/06/Yncrea_BM_HEI_horizontal_couleurs_RVB_300dpi-2.png\" /></center>" +

                                    "</body>" +
                                    "</html>";
                    mess.setContent(messageVal, "text/html; charset=UTF-8");

                    break;


                case "evenementSupprime":
                    mess.setSubject("Evènement non validé");

                    String messageSuppr =
                            "<html>" +
                                    "<body bgcolor=\"#ffffff\" style=\"padding-left:20px;padding-right:20px\"\">"
                                    + "<div style=\"background-color: #cc0000;margin-top:20px; color:white; border-radius: 4px;padding:15px;\"><center><strong>"
                                    + "<center><font size=\"5\">Bonjour " + nomCommission + ", votre évènement <u>n'a pas</u> été validé.</font></center>"
                                    + "</div>"
                                    + "<div><p style=\"border:1px solid black;padding:10px;border-radius:3px;\">"
                                    + "<u>Résumé de l'évènement :</u> " + "</br>"
                                    + "Date et heure : " + dateHeureFormatee + "</br>"
                                    + "Libellé : " + libelle + "</br>"
                                    + "Description : " + description + "</br>"
                                    + "Lieu : " + lieu + "</br>"
                                    + "Durée : " + duree + " h</br>"
                                    + "Nombre de postes : " + nbPostes + " étudiants</br></br>"
                                    + "</p></div>"
                                    + "<div><center><strong>Si ce message ne vous est pas destiné, ou pour un quelconque problème, contacter nous sur <a href=\"mailto:tea@hei.fr\">tea@hei.fr</a> ." + "</br>"
                                    + "Ne répondez pas à ce message s'il vous plait.</strong></center></div>"
                                    + "<center><img height=\"70px\" src=\"http://www.hei.fr/wp-content/uploads/2017/06/Yncrea_BM_HEI_horizontal_couleurs_RVB_300dpi-2.png\" /></center>" +

                                    "</body>" +
                                    "</html>";
                    mess.setContent(messageSuppr, "text/html; charset=UTF-8");
                    break;

                case "etudiantInscrit":
                    mess.setSubject("TEA - Confirmation de votre inscription");

                    String messageInscr =
                            "<html>" +
                                    "<body bgcolor=\"#ffffff\" style=\"padding-left:20px;padding-right:20px\"\">"
                                    + "<div style=\"background-color: #cc0000;margin-top:20px; color:white; border-radius: 4px;padding:15px;\"><center><strong>"
                                    + "<center><font size=\"5\">Bonjour, nous confirmons votre inscription à l'évènement suivant :</font></center>"
                                    + "</div>"
                                    + "<div><p style=\"border:1px solid black;padding:10px;border-radius:3px;\">"
                                    + "<u>Résumé de l'évènement :</u> " + "</br>"
                                    + "Demandeur : " + nomCommission + "</br>"
                                    + "Date et heure : " + dateHeureFormatee + "</br>"
                                    + "Libellé : " + libelle + "</br>"
                                    + "Description : " + description + "</br>"
                                    + "Lieu : " + lieu + "</br>"
                                    + "Durée : " + duree + " h</br>"
                                    + "Nombre de postes : " + nbPostes + " étudiants</br></br>"
                                    + "</p></div>"
                                    + "<div><center><strong>Si ce message ne vous est pas destiné, ou pour un quelconque problème, contacter nous sur <a href=\"mailto:tea@hei.fr\">tea@hei.fr</a> ." + "</br>"
                                    + "Ne répondez pas à ce message s'il vous plait.</strong></center></div>"
                                    + "<center><img height=\"70px\" src=\"http://www.hei.fr/wp-content/uploads/2017/06/Yncrea_BM_HEI_horizontal_couleurs_RVB_300dpi-2.png\" /></center>" +

                                    "</body>" +
                                    "</html>";
                    mess.setContent(messageInscr, "text/html; charset=UTF-8");

                    //invitation

                    Message invit = new MimeMessage(session);
                    invit.setFrom(new InternetAddress(from));
                    invit.addRecipient(Message.RecipientType.TO, new InternetAddress(to));


                    Multipart multiPart = new MimeMultipart("alternative");
                    MimeBodyPart eventPart = new MimeBodyPart();

                    StringBuilder sb = new StringBuilder();

                    String dateHeureDebut ="";
                    String dateHeureFin ="";

                    Calendar caldebut = Calendar.getInstance();
                    Calendar calfin = Calendar.getInstance();

                    caldebut.setTimeInMillis(dateHeure.getTime());
                    caldebut.add(Calendar.HOUR,-2);
                    Timestamp dateDebut =  new Timestamp(caldebut.getTime().getTime());

                    calfin.setTimeInMillis(dateHeure.getTime());
                    calfin.add(Calendar.HOUR, -2+duree);
                    Timestamp dateFin =  new Timestamp(calfin.getTime().getTime());


                    dateHeureDebut=dateDebut.toString();
                    dateHeureDebut=dateHeureDebut.substring(0,dateHeureDebut.length()-4);
                    dateHeureDebut=dateHeureDebut.replaceAll("-","").replaceAll(":","").replaceAll(" ","T");
                    dateHeureDebut=dateHeureDebut+"00";

                    dateHeureFin=dateFin.toString();
                    dateHeureFin=dateHeureFin.substring(0,dateHeureFin.length()-4);
                    dateHeureFin=dateHeureFin.replaceAll("-","").replaceAll(":","").replaceAll(" ","T");
                    dateHeureFin=dateHeureFin+"00";

                    System.out.println("DEBUT ///"+ dateHeureDebut);
                    System.out.println("FIN ///"+ dateHeureFin);






                    StringBuilder buffer = sb.append("BEGIN:VCALENDAR\n" +
                            "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n" +
                            "VERSION:2.0\n" +
                            "METHOD:REQUEST\n" +
                            "BEGIN:VEVENT\n" +
                            "ATTENDEE;ROLE=REQ-PARTICIPANT;RSVP=FALSE\n" +
                            "ORGANIZER:"+nomCommission+"\n" +
                            "DTSTART:"+dateHeureDebut+"\n" +
                            "DTEND:"+dateHeureFin+"\n" +
                            "LOCATION:"+lieu+"\n" +
                            "TRANSP:OPAQUE\n" +
                            "SEQUENCE:0\n" +
                            "UID:"+ ThreadLocalRandom.current().nextInt(1, 10000 + 1)+"\n" +
                            "CATEGORIES:Meeting\n" +
                            "DESCRIPTION:\n Il se peut que l'heure de l'évènement se decalle d'une heure en fonction de l'heure d'été/hiver\n\n" +
                            "SUMMARY:"+libelle+"\n" +
                            "PRIORITY:5\n" +
                            "CLASS:PUBLIC\n" +
                            "BEGIN:VALARM\n" +
                            "TRIGGER:PT1440M\n" +
                            "ACTION:DISPLAY\n" +
                            "DESCRIPTION:Reminder\n" +
                            "END:VALARM\n" +
                            "END:VEVENT\n" +
                            "END:VCALENDAR");


                    eventPart.setHeader("Content-Class", "urn:content-  classes:calendarmessage");
                    eventPart.setHeader("Content-ID", "calendar_message");
                    eventPart.setDataHandler(new DataHandler(
                            new ByteArrayDataSource(buffer.toString(), "text/calendar")));



                    multiPart.addBodyPart(eventPart);
                    invit.setContent(multiPart);
                    invit.setSubject("TEA");


                    Transport transInvit = null;

                    transInvit = session.getTransport("smtp");
                    invit.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    transInvit.connect("smtp.gmail.com", 587, maildelAutomailing, motdepasse);
                    transInvit.sendMessage(invit, invit.getAllRecipients());

                    System.out.println("Invitation envoyé ! !");


                    break;
                        case "etudiantDesinscrit":
                            mess.setSubject("TEA - Confirmation de votre désinscription");

                            String messageDesinscr =
                                    "<html>" +
                                            "<body bgcolor=\"#ffffff\" style=\"padding-left:20px;padding-right:20px\"\">"
                                            + "<div style=\"background-color: #cc0000;margin-top:20px; color:white; border-radius: 4px;padding:15px;\"><center><strong>"
                                            + "<center><font size=\"5\">Bonjour, nous confirmons votre <u>désinscription</u> à l'évènement suivant :</font></center>"
                                            + "</div>"
                                            + "<div><p style=\"border:1px solid black;padding:10px;border-radius:3px;\">"
                                            + "<u>Résumé de l'évènement :</u> " + "</br>"
                                            + "Demandeur : " + nomCommission + "</br>"
                                            + "Date et heure : " + dateHeureFormatee + "</br>"
                                            + "Libellé : " + libelle + "</br>"
                                            + "Description : " + description + "</br>"
                                            + "Lieu : " + lieu + "</br>"
                                            + "Durée : " + duree + " h</br>"
                                            + "Nombre de postes : " + nbPostes + " étudiants</br></br>"
                                            + "</p></div>"
                                            + "<div><center><strong><u>Les désinscription sont comptabilisées</u>, une inscription à un évènement vous engage auprès de la commission</strong></center></div><br>"
                                            + "<div><center><strong>Si ce message ne vous est pas destiné, ou pour un quelconque problème, contacter nous sur <a href=\"mailto:tea@hei.fr\">tea@hei.fr</a> ." + "</br>"
                                            + "Ne répondez pas à ce message s'il vous plait.</strong></center></div>"
                                            + "<center><img height=\"70px\" src=\"http://www.hei.fr/wp-content/uploads/2017/06/Yncrea_BM_HEI_horizontal_couleurs_RVB_300dpi-2.png\" /></center>" +

                                            "</body>" +
                                            "</html>";
                            mess.setContent(messageDesinscr, "text/html; charset=UTF-8");
                            break;
                        case "creationCommission":
                            mess.setSubject("TEA - Création de votre compte commission");

                            String messageCreation =
                                    "<html>" +
                                            "<body bgcolor=\"#ffffff\" style=\"padding-left:20px;padding-right:20px\"\">"
                                            + "<div style=\"background-color: #cc0000;margin-top:20px; color:white; border-radius: 4px;padding:15px;\"><center><strong>"
                                            + "<center><font size=\"5\">Bonjour " + nomCommission + ", nous confirmons la création de votre compte :</font></center>"
                                            + "</div>"
                                            + "<div><p style=\"border:1px solid black;padding:10px;border-radius:3px;\">"
                                            + "<u>Vos identifiants de connexion :</u> " + "<br><br>"
                                            + "Login : " + description + "<br>"
                                            + "Mot de passe : " + libelle + "<br>"
                                            + "</br></br>"
                                            + "</p></div>"
                                            + "<div><center><strong>Si ce message ne vous est pas destiné, ou pour un quelconque problème, contacter nous sur <a href=\"mailto:tea@hei.fr\">tea@hei.fr</a> ." + "</br>"
                                            + "Ne répondez pas à ce message s'il vous plait.</strong></center></div>"
                                            + "<center><img height=\"70px\" src=\"http://www.hei.fr/wp-content/uploads/2017/06/Yncrea_BM_HEI_horizontal_couleurs_RVB_300dpi-2.png\" /></center>" +

                                            "</body>" +
                                            "</html>";
                            mess.setContent(messageCreation, "text/html; charset=UTF-8");
                            break;
                        case "modifierCommission":
                            mess.setSubject("TEA - Modification de votre compte commission");

                            String messageModif =
                                    "<html>" +
                                            "<body bgcolor=\"#ffffff\" style=\"padding-left:20px;padding-right:20px\"\">"
                                            + "<div style=\"background-color: #cc0000;margin-top:20px; color:white; border-radius: 4px;padding:15px;\"><center><strong>"
                                            + "<center><font size=\"5\">Bonjour " + nomCommission + ", nous confirmons la <u>modification</u> de votre compte :</font></center>"
                                            + "</div>"
                                            + "<div><p style=\"border:1px solid black;padding:10px;border-radius:3px;\">"
                                            + "<u>Vos identifiants de connexion :</u> " + "<br><br>"
                                            + "Login : " + description + "<br>"
                                            + "Mot de passe : " + libelle + "<br>"
                                            + "</br></br>"
                                            + "</p></div>"
                                            + "<div><center><strong>Si ce message ne vous est pas destiné, ou pour un quelconque problème, contacter nous sur <a href=\"mailto:tea@hei.fr\">tea@hei.fr</a> ." + "</br>"
                                            + "Ne répondez pas à ce message s'il vous plait.</strong></center></div>"
                                            + "<center><img height=\"70px\" src=\"http://www.hei.fr/wp-content/uploads/2017/06/Yncrea_BM_HEI_horizontal_couleurs_RVB_300dpi-2.png\" /></center>" +

                                            "</body>" +
                                            "</html>";
                            mess.setContent(messageModif, "text/html; charset=UTF-8");
                            break;
                        case "etudiantDesinscritTARD":
                            mess.setSubject("Désinscription tardive TEA");

                            String messageDesinsTARD =
                                    "<html>" +
                                            "<body bgcolor=\"#ffffff\" style=\"padding-left:20px;padding-right:20px\"\">"
                                            + "<div style=\"background-color: #cc0000;margin-top:20px; color:white; border-radius: 4px;padding:15px;\"><center><strong>"
                                            + "<center><font size=\"5\">Bonjour " + nomCommission + ", " + description + " s'est désinscrit tardivement à votre évènement.</font></center>"
                                            + "</div>"
                                            + "<div><p style=\"border:1px solid black;padding:10px;border-radius:3px;\">"
                                            + "<u>Résumé de l'évènement :</u> " + "</br>"
                                            + "Date et heure : " + dateHeureFormatee + "</br>"
                                            + "Libellé : " + libelle + "</br>"
                                            + "Lieu : " + lieu + "</br>"
                                            + "Durée : " + duree + " h</br>"
                                            + "Nombre de postes : " + nbPostes + " étudiants</br></br>"
                                            + "</p></div>"
                                            + "<div><center><i>Vous recevez un mail pour chaque désinscription ayant lieu moins de 24h avant l'évènement</i></center></div>"
                                            + "<div><center><strong>Si ce message ne vous est pas destiné, ou pour un quelconque problème, contacter nous sur <a href=\"mailto:tea@hei.fr\">tea@hei.fr</a> ." + "</br>"
                                            + "Ne répondez pas à ce message s'il vous plait.</strong></center></div>"
                                            + "<center><img height=\"70px\" src=\"http://www.hei.fr/wp-content/uploads/2017/06/Yncrea_BM_HEI_horizontal_couleurs_RVB_300dpi-2.png\" /></center>" +

                                            "</body>" +
                                            "</html>";
                            mess.setContent(messageDesinsTARD, "text/html; charset=UTF-8");
                            break;



                 }
            Transport trans = session.getTransport("smtp");
            trans.connect("smtp.gmail.com", 587, maildelAutomailing, motdepasse);
            trans.sendMessage(mess, mess.getAllRecipients());

            System.out.println("Message envoyé ! !");
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String formatDateHeure(Timestamp dateHeure) {
        String phrase = "";
        if (dateHeure.toLocalDateTime().getDayOfWeek().name() == "MONDAY") {
            phrase += "Lundi ";
        }
        if (dateHeure.toLocalDateTime().getDayOfWeek().name() == "TUESDAY") {
            phrase += "Mardi ";
        }
        if (dateHeure.toLocalDateTime().getDayOfWeek().name() == "WEDNESDAY") {
            phrase += "Mercredi ";
        }
        if (dateHeure.toLocalDateTime().getDayOfWeek().name() == "THURSDAY") {
            phrase += "Jeudi ";
        }
        if (dateHeure.toLocalDateTime().getDayOfWeek().name() == "FRIDAY") {
            phrase += "Vendredi ";
        }
        if (dateHeure.toLocalDateTime().getDayOfWeek().name() == "SATURDAY") {
            phrase += "Samedi ";
        }
        if (dateHeure.toLocalDateTime().getDayOfWeek().name() == "SUNDAY") {
            phrase += "Dimanche ";
        }
        phrase += dateHeure.toLocalDateTime().getDayOfMonth();
        if (dateHeure.toLocalDateTime().getMonth().name() == "JANUARY") {
            phrase += " Janvier ";
        }
        if (dateHeure.toLocalDateTime().getMonth().name() == "FEBRUARY") {
            phrase += " Fevrier ";
        }
        if (dateHeure.toLocalDateTime().getMonth().name() == "MARCH") {
            phrase += " Mars ";
        }
        if (dateHeure.toLocalDateTime().getMonth().name() == "APRIL") {
            phrase += " Avril ";
        }
        if (dateHeure.toLocalDateTime().getMonth().name() == "MAY") {
            phrase += " Mai ";
        }
        if (dateHeure.toLocalDateTime().getMonth().name() == "JUNE") {
            phrase += " Juin ";
        }
        if (dateHeure.toLocalDateTime().getMonth().name() == "JULY") {
            phrase += " Juillet ";
        }
        if (dateHeure.toLocalDateTime().getMonth().name() == "AUGUST") {
            phrase += " Août ";
        }
        if (dateHeure.toLocalDateTime().getMonth().name() == "SEPTEMBER") {
            phrase += " Septembre ";
        }
        if (dateHeure.toLocalDateTime().getMonth().name() == "OCTOBER") {
            phrase += " Octobre ";
        }
        if (dateHeure.toLocalDateTime().getMonth().name() == "NOVEMBER") {
            phrase += " Novembre ";
        }
        if (dateHeure.toLocalDateTime().getMonth().name() == "DECEMBER") {
            phrase += " Décembre ";
        }
        phrase += dateHeure.toLocalDateTime().getYear();
        phrase += " à ";
        phrase += dateHeure.toLocalDateTime().getHour();
        phrase += 'h';
        if (dateHeure.toLocalDateTime().getMinute() < 10) {
            phrase += '0';
            phrase += dateHeure.toLocalDateTime().getMinute();
        } else {
            phrase += dateHeure.toLocalDateTime().getMinute();
        }
        return phrase;
    }




}
