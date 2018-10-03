/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import models.Models_bloc;
import views.Views_bloc;

/**
 *
 * @author LAB-1
 */
public class Controllers_bloc {
    private final Models_bloc models_bloc;
    private final Views_bloc views_bloc;
    
    public Controllers_bloc(Models_bloc models_bloc, Views_bloc views_bloc){
        this.models_bloc = models_bloc;
        this.views_bloc = views_bloc;
        views_bloc.JMI_Read.addActionListener((ActionListener) this);
        views_bloc.JMI_Write.addActionListener((ActionListener) this);
        initView();
    }
    
     public void actionPerformed(ActionEvent e) {
        if(e.getSource()==views_bloc.JMI_Read){
            seleccionarRuta();
            models_bloc.readFile(models_bloc.getPath());      
            views_bloc.JTA_Txt.setText(models_bloc.getMessage());
        }else if(e.getSource()==views_bloc.JMI_Write){
            seleccionarRuta();
            models_bloc.setMessage(views_bloc.JTA_Txt.getText());
            models_bloc.writeFile(models_bloc.getPath(), models_bloc.getMessage());
        }
    }
     private void initView() {
        views_bloc.setTitle("Block de notas");
        views_bloc.setResizable(false);
        views_bloc.setLocationRelativeTo(null);
        views_bloc.setVisible(true);
    }   

    private void seleccionarRuta() {
        JFileChooser file=new JFileChooser();
        file.showSaveDialog(null);
        models_bloc.setPath(""+file.getSelectedFile());
    }
}
