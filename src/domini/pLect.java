package domini;

import java.util.Date;

public class pLect
{
    public Date dataIni;
    public Date dataFi;

    public pLect(Date dataIni, Date dataFi) {
        this.dataIni = dataIni;
        this.dataFi  = dataFi;
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

}