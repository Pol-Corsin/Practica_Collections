package model;

import model.object.Producte;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Producte> magatzem = new ArrayList<>();
    private List<String> tiquetsCompra = new ArrayList<>();

    public void afegirProducte(Producte producte) {
        magatzem.add(producte);
    }

    public List<Producte> getMagatzem() {
        return magatzem;
    }

    public List<String> getTiquetsCompra() {
        return tiquetsCompra;
    }

    public void afegirTiquet(String tiquet) {
        tiquetsCompra.add(tiquet);
    }

    public void buidarMagatzem() {
        magatzem.clear();
    }
}