package domini;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class pLect
{
    private Date dataIni;
    private Date dataFi;

    public pLect(Date DataIni, Date DateFi) {
        this.dataIni = dataIni;
        this.dataFi  = dataFi;
    }

    public pLect(@NotNull pLect pL) {
        this.dataIni = pL.getDataIni();
        this.dataFi  = pL.getDataFi();
    }

    public void setDataIni(Date dataIni) {
        this.dataIni = dataIni;
    }

    public void setDataFi(Date dataFi) {
        this.dataFi = dataFi;
    }

    public Date getDataIni() {
        return dataIni;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public void print_pLect() {
        System.out.println("DataIni: " + this.getDataIni());
        System.out.println("DataFi : " + this.getDataFi());
    }

}