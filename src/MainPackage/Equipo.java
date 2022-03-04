package MainPackage;
public class Equipo {
    private String name;
    private int pj;
    private int pg;   
    private int pe;
    private int pp;
    private int gf;
    private int gc;
    private int dg;
    private int pts;

    public Equipo(String name) {
        this.name = name;
        this.pj = 0;
        this.pg = 0;
        this.pe = 0;
        this.pp = 0;
        this.gf = 0;
        this.gc = 0;
        this.dg = 0;
        this.pts = 0;
    }

    public Equipo(String name, int pj, int pg, int pe, int pp, int gf, int gc, int dg, int pts) {
        this.name = name;
        this.pj = pj;
        this.pg = pg;
        this.pe = pe;
        this.pp = pp;
        this.gf = gf;
        this.gc = gc;
        this.dg = dg;
        this.pts = pts;
    }
    
    /**
     * Get the value of pg
     *
     * @return the value of pg
     */
    public int getPg() {
        return pg;
    }

    /**
     * Set the value of pg
     *
     * @param pg new value of pg
     */
    public void setPg(int pg) {
        this.pg = pg;
    }

    
    /**
     * Get the value of dg
     *
     * @return the value of dg
     */
    public int getDg() {
        return dg;
    }

    /**
     * Set the value of dg
     *
     * @param dg new value of dg
     */
    public void setDg(int dg) {
        this.dg = dg;
    }

    
    /**
     * Get the value of pp
     *
     * @return the value of pp
     */
    public int getPp() {
        return pp;
    }

    /**
     * Set the value of pp
     *
     * @param pp new value of pp
     */
    public void setPp(int pp) {
        this.pp = pp;
    }

    
    /**
     * Get the value of pe
     *
     * @return the value of pe
     */
    public int getPe() {
        return pe;
    }

    /**
     * Set the value of pe
     *
     * @param pe new value of pe
     */
    public void setPe(int pe) {
        this.pe = pe;
    }

    
    
    /**
     * Get the value of pj
     *
     * @return the value of pj
     */
    public int getPj() {
        return pj;
    }

    /**
     * Set the value of pj
     *
     * @param pj new value of pj
     */
    public void setPj(int pj) {
        this.pj = pj;
    }

    
    /**
     * Get the value of pts
     *
     * @return the value of pts
     */
    public int getPts() {
        return pts;
    }

    /**
     * Set the value of pts
     *
     * @param pts new value of pts
     */
    public void setPts(int pts) {
        this.pts = pts;
    }

    
    /**
     * Get the value of gc
     *
     * @return the value of gc
     */
    public int getGc() {
        return gc;
    }

    /**
     * Set the value of gc
     *
     * @param gc new value of gc
     */
    public void setGc(int gc) {
        this.gc = gc;
    }

    
    /**
     * Get the value of gf
     *
     * @return the value of gf
     */
    public int getGf() {
        return gf;
    }

    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setGf(int gf) {
        this.gf = gf;
    }
    

    @Override
    public String toString() {
        return name + ";" + pj + ";" + pg + ";" + pe + ";" + pp + ";" + gf + ";" + gc + ";" + dg + ";" + pts;
    }

    
    
}
