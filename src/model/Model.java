package model;

import model.object.Producte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private List<Producte> magatzem = new ArrayList<>();
    private Map<String, Producte> carretCompra = new HashMap<>();
    private List<String> tiquetsCompra = new ArrayList<>();

    public void afegirProducte(Producte producte) {
        magatzem.add(producte);
    }

    public List<Producte> getMagatzem() {
        return magatzem;
    }

    public Map<String, Producte> getCarretCompra() {
        return carretCompra;
    }

    public List<String> getTiquetsCompra() {
        return tiquetsCompra;
    }

    public void afegirTiquet(String tiquet) {
        tiquetsCompra.add(tiquet);
    }

    public void buidarCarretCompra() {
        carretCompra.clear();
    }
}