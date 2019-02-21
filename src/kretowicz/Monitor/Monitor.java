package kretowicz.Monitor;

import kretowicz.gui.Tile;

public class Monitor {
    private Tile lastTile;

    public void setLastTile(Tile lastTile) {
        this.lastTile = lastTile;
    }

    public Tile getLastTile() {
        return lastTile;
    }
}
