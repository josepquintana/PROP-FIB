package presentacio;

import domini.ControladorDomini;
import domini.MyException;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPresentacio
{
    private ControladorDomini ctrlDom;
    private VistaPresentacio vistaPresentacio;
    private VistaPrincipal vistaPrincipal;
    private VistaGestioCD vistaGestioCD;
    private VistaGestioPE vistaGestioPE;
    private VistaGestioAula vistaGestioAula;
    private VistaGestioCalendari vistaGestioCalendari;
    private VistaCrearAula vistaCrearAula;
    private VistaConsultarAula vistaConsultarAula;
    private VistaHorari vistaHorari;
    private VistaInfoPE vistaInfoPE;
    private VistaGestioAssig vistaGestioAssig;
    private VistaCrearAssig vistaCrearAssig;
    private VistaModificarHorari vistaModificarHorari;
    private VistaConsultarAssig vistaConsultarAssig;
    private String[][] horari;

    public ControladorPresentacio() {
        try {
            ctrlDom = new ControladorDomini();
            this.loadDataDomini();
        } catch (IOException e) {
            MyDialog.throwError("No s'han pogut generar els fitxers de dades necessaris.\n" +
                                "El directori \".." + File.separator + "fitxersDades\" no s'ha trobat.");
        }
        vistaPresentacio = new VistaPresentacio(this);
        vistaPrincipal = new VistaPrincipal(this);
        vistaGestioCD = new VistaGestioCD(this);
        vistaGestioAula = new VistaGestioAula(this);
        vistaCrearAula = new VistaCrearAula(this);
        vistaGestioCalendari = new VistaGestioCalendari(this);
        vistaConsultarAula = new VistaConsultarAula(this);
        vistaHorari = new VistaHorari(this);
        vistaGestioPE = new VistaGestioPE(this);
        vistaInfoPE = new VistaInfoPE(this);
        vistaGestioAssig = new VistaGestioAssig(this);
        vistaCrearAssig = new VistaCrearAssig(this);
        vistaConsultarAssig = new VistaConsultarAssig(this);
        vistaModificarHorari = new VistaModificarHorari(this);
    }

    public void inicialitzarPresentacio() {
        vistaPresentacio.setVisible(true);
        vistaPresentacio.ferVisible();
    }

    /**
     * Metodes de sincronitzacio entre vistes
     */

    public void sincronitzacioVistaPresentacio_a_Principal() {
        vistaPresentacio.setVisible(false);
        vistaPresentacio.desactivar();
        vistaPrincipal.setVisible(true);
        vistaPrincipal.ferVisible();
    }

    public void sincronitzacioVistaPrincipal_a_GestioCD() {
        vistaPrincipal.setVisible(false);
        vistaPrincipal.desactivar();
        vistaGestioCD.setVisible(true);
        vistaGestioCD.ferVisible();
    }

    public void sincronitzacioGestioCD_a_VistaPrincipal() {
        vistaGestioCD.setVisible(false);
        vistaGestioCD.desactivar();
        vistaPrincipal.setVisible(true);
        vistaPrincipal.ferVisible();
    }

    public void sincronitzacioVistaPrincipal_a_GestioPE() {
        vistaPrincipal.setVisible(false);
        vistaPrincipal.desactivar();
        vistaGestioPE.setVisible(true);
        vistaGestioPE.ferVisible();
    }

    public void sincronitzacioGestioPE_a_VistaPrincipal() {
        vistaGestioPE.setVisible(false);
        vistaGestioPE.desactivar();
        vistaPrincipal.setVisible(true);
        vistaPrincipal.ferVisible();
    }

    public void sincronitzacioGestioAula_a_GestioCD() {
        vistaGestioAula.setVisible(false);
        vistaGestioAula.desactivar();
        vistaGestioCD.setVisible(true);
        vistaGestioCD.ferVisible();
    }

    public void sincronitzacioGestioCD_a_GestioAules() {
        vistaGestioCD.setVisible(false);
        vistaGestioCD.desactivar();
        vistaGestioAula.setVisible(true);
        vistaGestioAula.ferVisible();
    }

    public void sincronitzacioGestioCalendari_a_GestioCD() {
        vistaGestioCalendari.setVisible(false);
        vistaGestioCalendari.desactivar();
        vistaGestioCD.setVisible(true);
        vistaGestioCD.ferVisible();
    }

    public void sincronitzacioGestioCD_a_GestioCalendari() {
        vistaGestioCD.setVisible(false);
        vistaGestioCD.desactivar();
        vistaGestioCalendari.iniciaValors();
        vistaGestioCalendari.setVisible(true);
        vistaGestioCalendari.ferVisible();
    }

    public void sincronitzacioGestioAula_a_CrearAula() {
        vistaGestioAula.setVisible(false);
        vistaGestioAula.desactivar();
        vistaCrearAula.setVisible(true);
        vistaCrearAula.ferVisible();
    }

    public void sincronitzacioCrearAula_a_GestioAula() {
        vistaCrearAula.setVisible(false);
        vistaCrearAula.desactivar();
        vistaGestioAula.setVisible(true);
        vistaGestioAula.ferVisible();
    }

    public void sincronitzacioConsultarAula_a_GestioAula() {
        vistaConsultarAula.setVisible(false);
        vistaConsultarAula.desactivar();
        vistaGestioAula.setVisible(true);
        vistaGestioAula.ferVisible();
    }

    public void sincronitzacioGestioAula_a_ConsultarAula() {
        vistaGestioAula.setVisible(false);
        vistaGestioAula.desactivar();
        this.refrescarAules();
        vistaConsultarAula.setVisible(true);
        vistaConsultarAula.ferVisible();
    }

    public void sincronitzacioVistaHorari_a_VistaPrincipal() {
        vistaHorari.setVisible(false);
        vistaHorari.desactivar();
        vistaPrincipal.setVisible(true);
        vistaPrincipal.ferVisible();
    }

    public void sincronitzacioVistaPrincipal_a_VistaHorari() {
        vistaPrincipal.setVisible(false);
        vistaPrincipal.desactivar();
        vistaHorari.setVisible(true);
        vistaHorari.ferVisible();
    }

    public void sincronitzacioVistaModificarHorari_a_VistaHorari() {
        vistaModificarHorari.setVisible(false);
        vistaModificarHorari.desactivar();
        vistaHorari.setVisible(true);
        vistaHorari.ferVisible();
    }

    public void sincronitzacioVistaHorari_a_VistaModificarHorari() {
        vistaHorari.setVisible(false);
        vistaHorari.desactivar();
        vistaModificarHorari.setVisible(true);
        vistaModificarHorari.ferVisible();
    }

    public void sincronitzacioGestioPE_a_VistaInfoPE() {
        vistaGestioPE.setVisible(false);
        vistaGestioPE.desactivar();
        vistaInfoPE.iniciaValors();
        vistaInfoPE.setVisible(true);
        vistaInfoPE.ferVisible();
    }

    public void sincronitzacioVistaInfoPE_a_VistaGestioPE(){
        vistaInfoPE.setVisible(false);
        vistaInfoPE.desactivar();
        vistaGestioPE.setVisible(true);
        vistaGestioPE.ferVisible();
    }

    public void sincronitzacioVistaGestioAssig_a_VistaGestioPE() {
        vistaGestioAssig.setVisible(false);
        vistaGestioAssig.desactivar();
        vistaGestioPE.setVisible(true);
        vistaGestioPE.ferVisible();
    }

    public void sincronitzacioVistaGestioPE_a_VistaGestioAssig() {
        vistaGestioPE.setVisible(false);
        vistaGestioPE.desactivar();
        vistaGestioAssig.setVisible(true);
        vistaGestioAssig.ferVisible();
    }

    public void sincronitzacioGestioAssig_a_CrearAssig() {
        vistaGestioAssig.setVisible(false);
        vistaGestioAssig.desactivar();
        vistaCrearAssig.setVisible(true);
        vistaCrearAssig.ferVisible();
    }

    public void sincronitzacioCrearAssig_a_GestioAssig() {
        vistaCrearAssig.setVisible(false);
        vistaCrearAssig.desactivar();
        vistaGestioAssig.setVisible(true);
        vistaGestioAssig.ferVisible();
    }

    public void sincronitzacioGestioAssig_a_ConsultarAssig() {
        vistaGestioAssig.setVisible(false);
        vistaGestioAssig.desactivar();
        this.refrescarAssig();
        vistaConsultarAssig.setVisible(true);
        vistaConsultarAssig.ferVisible();
    }

    public void sincronitzacioConsultarAssig_a_GestioAssig() {
        vistaConsultarAssig.setVisible(false);
        vistaConsultarAssig.desactivar();
        vistaGestioAssig.setVisible(true);
        vistaGestioAssig.ferVisible();
    }

    /**
     *  Crides al controlador de domini per obtenir les dades necesaries
     */

    public void crearAula(String nom, String capacitat, String laboratori) {
        try {
            ctrlDom.crearAula(nom, capacitat, laboratori);
        } catch (MyException e) {
            MyDialog.throwError("Error: " + e.getMessage());
        }
    }

    public void modificarAula(String codi, String nom, String capacitat, String laboratori) {
         ctrlDom.modificarAula(codi, nom, capacitat, laboratori);
    }

    public void eliminarAula(String codi) {
         ctrlDom.eliminarAula(codi);
    }

    public void crearAssig(String line){
        try {
            ctrlDom.crearAssig(line);
        } catch (MyException e) {
            MyDialog.throwError("Error: " + e.getMessage());
        }
    }

    public void eliminarAssig(String codi) {
         ctrlDom.eliminarAssig(codi);
    }

    public String[] getNomAules(){
        return ctrlDom.getNomAules();
    }

    public String[] getCodiAssigs() {
        String[] codis = ctrlDom.getCodiAssigs(0);
        if (codis != null) { return codis; }
        codis = new String[1];
        codis[0] = "";
        return codis;
    }

    public int getNumAules(){
        return ctrlDom.getNumAules();
    }

    public String getCapacitatAula(String codi){
        return ctrlDom.getCapacitatAula(codi);
    }

    public String getLab(String codi){
        return ctrlDom.getLab(codi);
    }

    public String getNomAssig(String codi){
        return ctrlDom.getNomAssig(codi);
    }

    public String geCredits(String codi){
        return ctrlDom.getCredits(codi);
    }

    public String getCapacitatAssignatura(String codi) { return ctrlDom.getCapacitatAssig(codi); }

    public String getGrups(String codi){
        return ctrlDom.getGrups(codi);
    }

    public String getSubgrups(String codi){
        return ctrlDom.getSubgrups(codi);
    }

    public String getNivell(String codi){
        return ctrlDom.getNivell(codi);
    }

    public String getALab(String codi){
        return ctrlDom.getALab(codi);
    }

    public String getCorreq(String codi){
        return ctrlDom.getCorreq(codi);
    }

    public void refrescarAules(){
        vistaConsultarAula = new VistaConsultarAula(this);
        vistaConsultarAula.desactivar();
    }

    public void refrescarAssig(){
        vistaConsultarAssig = new VistaConsultarAssig(this);
        vistaConsultarAssig.desactivar();
    }

    public boolean generarHorari() {
        try {
            boolean a = ctrlDom.generarHorari();
            vistaHorari.carregarLlistaHores();
            return a;
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ControladorPresentacio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MyException e) {
            MyDialog.throwError(e.getMessage());
        }
        return false;
    }

    public boolean swapHorari(int ia, int ja, int ka, int ib, int jb, int kb){
        try {
            return ctrlDom.swapHorariPla(ia, ja, ka, ib, jb, kb, 0);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ControladorPresentacio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public String getJornadaLectiva(){
        String horaIni = ctrlDom.getHoraIni();
        String horaFi  = ctrlDom.getHoraFi();
        return (horaIni + " " + horaFi);
    }

    public String getPeriodeLectiu(){
        String dataIni = ctrlDom.getDataIni();
        String dataFi  = ctrlDom.getDataFi();
        return (dataIni + " " + dataFi);
    }

    public int getHoraIni(){
        return this.ctrlDom.getHoraIniInteger();
    }

    public String[][] getHorari() {
        try {
            horari = ctrlDom.getHorari(0);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ControladorPresentacio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MyException e) {
            MyDialog.throwError(e.getMessage());
        }
        return horari;
    }

    public int getNumPlans(){
        return ctrlDom.getPlansDeEstudis().mida();
    }

    public String getNomPla(){
        String s = ctrlDom.getNomPla();
        return s;
    }

    public String getNomTitulacio(){
        String s = ctrlDom.getNomTitulacio();
        return s;
    }

    public String getTipusTitulacio(){
        String s = ctrlDom.getTipusTitulacio();
        return s;
    }

    public void modificarCalendari(String jornada, String periode) throws ParseException{
        ctrlDom.modificarCalendari(jornada, periode);
    }

    public void modificarPla(String nom, String titulacio, String tipus) throws ParseException{
        ctrlDom.modificarPla(nom, titulacio, tipus);
    }

    public void afegirPla(String nom, String titulacio, String tipus) throws ParseException{
        try {
            ctrlDom.afegirPla(nom, titulacio, tipus);
        } catch (MyException e) {
            MyDialog.throwError(e.getMessage());
        }
    }

    public void loadDataDomini() {
        try {
          this.ctrlDom.loadDataAll();
        } catch (IOException e) {
            MyDialog.throwError("Error al llegir dades dels fitxers.");
        } catch (MyException e) {
            MyDialog.throwError("Error: " + e.getMessage());
        }
    }

    public void storeCentreDocent(){
        try {
            this.ctrlDom.storeDataCentreDocent();
        }
        catch (IOException ex) {
            MyDialog.throwError("Error al guardar dades.");
        }
    }

    public void storePlansDeEstudis() {
        try {
            this.ctrlDom.storeDataPlansDeEstudis();
        } catch (IOException | MyException ex) {
            MyDialog.throwError("Error al guardar dades.");
        }
    }

    public void storeAules() {
        try {
            this.ctrlDom.storeDataAules();
        } catch (IOException | InterruptedException ex) {
            MyDialog.throwError("Error al guardar dades.");
        }
    }

    public void storeAssignatures() {
        try {
            this.ctrlDom.storeDataAssignatures();
        }
        catch (IOException | MyException ex) {
            MyDialog.throwError("Error al guardar dades.");
        }
    }

    public void importarCentreDocent(File file){
        String centre;
        try {
            centre = ImportarFitxers.importCentreDocent(file);
            this.ctrlDom.importDataCentreDocent(centre);
        } catch (IOException ex) {
            MyDialog.throwError("Error al llegir el fitxer importat");
        }
    }

    public void importarPlansDeEstudis(File file){
        ArrayList<String> plans;
        try {
            plans = ImportarFitxers.importPlansDeEstudis(file);
            this.ctrlDom.importDataPlansDeEstudis(plans);
        } catch (MyException e) {
            MyDialog.throwError("Error al parsejar el contingut del fixter importat: " + e.getMessage());
        } catch (IOException e) {
            MyDialog.throwError("Error al llegir el fitxer importat");
        }
    }

    public void importarAules(File file){
        ArrayList<String> aules;
        try {
            aules = ImportarFitxers.importAules(file);
            this.ctrlDom.importDataAules(aules);
        } catch (MyException e) {
            MyDialog.throwError("Error al parsejar el contingut del fixter importat: " + e.getMessage());
        } catch (IOException e) {
            MyDialog.throwError("Error al llegir el fitxer importat");
        }
    }

    public void importarAssignatures(File file){
        ArrayList<String> assignatures;
        try {
           assignatures = ImportarFitxers.importAssignatures(file);
           this.ctrlDom.importDataAssignatures(assignatures);
        } catch (MyException ex) {
            MyDialog.throwError("Error al parsejar el contingut del fixter importat: " + ex.getMessage());
        } catch (IOException e) {
            MyDialog.throwError("Error al llegir el fitxer importat");
        }
    }

    public void importarTot(File file){
        this.importarCentreDocent(file);
        this.importarPlansDeEstudis(file);
        this.importarAules(file);
        this.importarAssignatures(file);
    }

}
