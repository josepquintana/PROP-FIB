package presentacio;

import dades.ControladorDades;
import domini.ControladorDomini;
import domini.MyException;
//import dades.ControladorDades;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPresentacio {
  private ControladorDomini ctrlDom;
  private ControladorDades ctrlDades;
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

  private VistaConsultarAssig vistaConsultarAssig;


//////////////////////// Constructor y metodos de inicializacion


  public ControladorPresentacio() throws IOException, CloneNotSupportedException, MyException {
    ctrlDom = new ControladorDomini();
    ctrlDom.loadData(); // carrega totes les dades dels fitxers "BD"
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

  }

  public void inicialitzarPresentacio() {
    //ctrlDomini.inicializarControladorDomini();
    vistaPresentacio.setVisible(true);
    vistaPresentacio.ferVisible();
  }


//////////////////////// Metodos de sincronizacion entre vistas


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
  
  public void sincronitzacioVistaHorari_a_VistaPrincipal(){
    vistaHorari.setVisible(false);
    vistaHorari.desactivar();
    vistaPrincipal.setVisible(true);
    vistaPrincipal.ferVisible();
  }

  public void sincronitzacioVistaPrincipal_a_VistaHorari(){
    vistaPrincipal.setVisible(false);
    vistaPrincipal.desactivar();
    vistaHorari.setVisible(true);
    vistaHorari.ferVisible();
  }

  public void sincronitzacioGestioPE_a_VistaInfoPE(){
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

  public void sincronitzacioVistaGestioAssig_a_VistaGestioPE(){
    vistaGestioAssig.setVisible(false);
    vistaGestioAssig.desactivar();
    vistaGestioPE.setVisible(true);
    vistaGestioPE.ferVisible();
  }

  public void sincronitzacioVistaGestioPE_a_VistaGestioAssig(){
    vistaGestioPE.setVisible(false);
    vistaGestioPE.desactivar();
    vistaGestioAssig.setVisible(true);
    vistaGestioAssig.ferVisible();
  }
  
  public void sincronitzacioGestioAssig_a_CrearAssig(){
    vistaGestioAssig.setVisible(false);
    vistaGestioAssig.desactivar();
    vistaCrearAssig.setVisible(true);
    vistaCrearAssig.ferVisible();
  }
  
  public void sincronitzacioCrearAssig_a_GestioAssig(){
    vistaCrearAssig.setVisible(false);
    vistaCrearAssig.desactivar();
    vistaGestioAssig.setVisible(true);
    vistaGestioAssig.ferVisible();
  }
  
  public void sincronitzacioGestioAssig_a_ConsultarAssig(){
    vistaGestioAssig.setVisible(false);
    vistaGestioAssig.desactivar();
    this.refrescarAssig();
    vistaConsultarAssig.setVisible(true);
   vistaConsultarAssig.ferVisible();
  }
  
  public void sincronitzacioConsultarAssig_a_GestioAssig(){
    vistaConsultarAssig.setVisible(false);
    vistaConsultarAssig.desactivar();
    vistaGestioAssig.setVisible(true);
    vistaGestioAssig.ferVisible();
  }
  




//////////////////////// Crides al controlador de dominio


  public void crearAula(String nom, String capacitat, String laboratori) throws MyException {
         ctrlDom.crearAula(nom, capacitat, laboratori);
  }
  
  public void modificarAula(String codi, String nom, String capacitat, String laboratori) throws MyException {
         ctrlDom.modificarAula(codi, nom, capacitat, laboratori);
  }
  
  public void modificarAssig(String codi1, String codi2, String nom,String credits,String grups,String subgrups,String nivell,String laboratori,String correq){
      ctrlDom.modificarAssig(codi1, codi2, nom, credits, grups, subgrups, nivell, laboratori, correq);
  }
  
  public void eliminarAula(String codi) throws MyException {
         ctrlDom.eliminarAula(codi);
  }
  
  public void eliminarAssig(String codi) throws MyException {
         ctrlDom.eliminarAssig(codi);
  }
  
  public String[] getNomAules(){
      return ctrlDom.getNomAules();
  }
  
  public String[] getCodiAssigs(){
      return ctrlDom.getCodiAssigs();
  }
  
  public int getNumAules(){
      return ctrlDom.getNumAules();
  }
  
  public void crearAssig(String codi, String nom, String laboratori, String credits, String nivell, String correq, String grups, String subgrups){
      ctrlDom.crearAssig(codi, nom, laboratori, credits, nivell, correq, grups, subgrups);
  }

  public String getCapacitat(String codi){
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
          return ctrlDom.generarHorari();
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
  
  public String[][] getHorari(){
      String[][] horari = new String[0][0];
      try {
          horari = ctrlDom.getHorari(0);
      } catch (CloneNotSupportedException ex) {
          Logger.getLogger(ControladorPresentacio.class.getName()).log(Level.SEVERE, null, ex);
      } catch (MyException ex) {
          MyDialog.throwError("Horari no generat");
      }
      return  horari;
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
      ctrlDom.afegirPla(nom, titulacio, tipus);
  }
  
  public void guardarDades(){
      try {
          this.ctrlDom.storeData();
      } catch (IOException ex) {
          Logger.getLogger(ControladorPresentacio.class.getName()).log(Level.SEVERE, null, ex);
      } catch (MyException ex) {
          Logger.getLogger(ControladorPresentacio.class.getName()).log(Level.SEVERE, null, ex);
      } catch (InterruptedException ex) {
          Logger.getLogger(ControladorPresentacio.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
  
}
