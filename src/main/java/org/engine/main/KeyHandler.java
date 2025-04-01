package org.engine.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Класс для обработки клавиш в игре.
public class KeyHandler implements KeyListener {
    public boolean isQ;
    public boolean isW;
    public boolean isE;
    public boolean isR;
    public boolean isT;
    public boolean isY;
    public boolean isU;
    public boolean isI;
    public boolean isO;
    public boolean isP;
    public boolean isA;
    public boolean isS;
    public boolean isD;
    public boolean isF;
    public boolean isG;
    public boolean isH;
    public boolean isJ;
    public boolean isK;
    public boolean isL;
    public boolean isZ;
    public boolean isX;
    public boolean isC;
    public boolean isV;
    public boolean isB;
    public boolean isN;
    public boolean isM;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        changeVars(code, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        changeVars(code, false);
    }

    private void changeVars(int code, boolean value){
        switch (code){
            case KeyEvent.VK_Q -> isQ = value;
            case KeyEvent.VK_W -> isW = value;
            case KeyEvent.VK_E -> isE = value;
            case KeyEvent.VK_R -> isR = value;
            case KeyEvent.VK_T -> isT = value;
            case KeyEvent.VK_Y -> isY = value;
            case KeyEvent.VK_U -> isU = value;
            case KeyEvent.VK_I -> isI = value;
            case KeyEvent.VK_O -> isO = value;
            case KeyEvent.VK_P -> isP = value;
            case KeyEvent.VK_A -> isA = value;
            case KeyEvent.VK_S -> isS = value;
            case KeyEvent.VK_D -> isD = value;
            case KeyEvent.VK_F -> isF = value;
            case KeyEvent.VK_G -> isG = value;
            case KeyEvent.VK_H -> isH = value;
            case KeyEvent.VK_J -> isJ = value;
            case KeyEvent.VK_K -> isK = value;
            case KeyEvent.VK_L -> isL = value;
            case KeyEvent.VK_Z -> isZ = value;
            case KeyEvent.VK_X -> isX = value;
            case KeyEvent.VK_C -> isC = value;
            case KeyEvent.VK_V -> isV = value;
            case KeyEvent.VK_B -> isB = value;
            case KeyEvent.VK_N -> isN = value;
            case KeyEvent.VK_M -> isM = value;
        }
    }
}
