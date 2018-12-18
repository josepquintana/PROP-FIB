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


  public ControladorPresentacio() throws IOException {
    ctrlDom = new ControladorDomini();
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
  
  public void eliminarAula(String codi) throws MyException {
         ctrlDom.eliminarAula(codi);
  }
  
  public String[] getNomAules(){
      return ctrlDom.getNomAules();
  }
  
  public int getNumAules(){
      return ctrlDom.getNumAules();
  }
  
  public void crearAssig(String codi, String nom, String laboratori, String credits, String nivell, String correq, String grups){
      ctrlDom.crearAssig(codi, nom, laboratori, credits, nivell, correq, grups);
  }

  public String getCapacitat(String codi){
      return ctrlDom.getCapacitat(codi);
  }
  
  public String getLab(String codi){
      return ctrlDom.getLab(codi);
  }
  
  public void refrescarAules(){
      vistaConsultarAula = new VistaConsultarAula(this);
      vistaConsultarAula.desactivar();
  }
  
  public void refrescarAssig(){
//      vistaConsultarAssig = new VistaConsultarAssig(this);
//      vistaConsultarAssig.desactivar();
  }
  
  public void generarHorari(){
      ctrlDom.generarHorari();
  }
  
  public String getJornadaLectiva(){
      String s1 = ctrlDom.getHoraIni();
      String s2 = ctrlDom.getHoraFi();
      String s = s1.concat(s2);
      return s;
  }
  
  public String getPeriodeLectiu(){
      String s1 = ctrlDom.getDataIni();
      String s2 = ctrlDom.getDataFi();
      String s = s1.concat(s2);
      return s;
  }
  
  public ArrayList<String>[][] getHorari(){
      return ctrlDom.getHorari();
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
  
}
