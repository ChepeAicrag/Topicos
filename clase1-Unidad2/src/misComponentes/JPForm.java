/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package misComponentes;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import misComponentes.JCInput;

/**
 * 
 * @author Garcia Garcia Jose Angel
 */
public class JPForm extends JPanel{
    private ArrayList<JCInput> lstJCInput;
    
    public JPForm (String[] txtCampos,String[] tipoComponente){
        setLayout(new  GridLayout(0, 1));
        lstJCInput = new ArrayList();
        for (int i = 0; i < txtCampos.length; i++) {
            JCInput input = new JCInput(txtCampos[i], tipoComponente[i]);
            add(input);
        }
        setVisible(true);
        updateUI();
    }
}
