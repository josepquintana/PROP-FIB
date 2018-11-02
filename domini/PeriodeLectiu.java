package domini;

import java.util.Date;

public class PeriodeLectiu
{
    private Date dataIni;
    private Date dataFi;

    public PeriodeLectiu() {
        this.dataIni = new Date();
        this.dataFi  = new Date();
    }

    public PeriodeLectiu(Date dataIni, Date dataFi) {
        this.dataIni = new Date(dataIni.getTime());
        this.dataFi  = new Date(dataFi.getTime());
    }

    public PeriodeLectiu(PeriodeLectiu pL) {
        this.dataIni = new Date(pL.getDataIni().getTime());
        this.dataFi  = new Date(pL.getDataFi().getTime());
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = new Date(dataIni.getTime());
    }

    public void setDataFi(Date dataFi) {
        this.dataFi = new Date(dataFi.getTime());
    }

    public Date getDataIni() {
        return dataIni;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void printPeriodeLectiu() {
        System.out.println(" dataIni: " + this.getDataIni());
        System.out.println(" dataFi : " + this.getDataFi());
    }

}