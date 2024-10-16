package com.efigenio.models;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class ControllerNotas{
    @FXML
    private TextField nota1Field;
    @FXML
    private TextField nota2Field;
    @FXML
    private TextField nota3Field;
    @FXML
    private TextField nota4Field;
    @FXML
    private Button salvarButton;

    private Aluno aluno;

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @FXML
    private void initialize() {
        salvarButton.setOnAction(e -> adicionarNotas());
    }

    private void adicionarNotas() {
        try {
            aluno.getNotas().setNota1(Double.parseDouble(nota1Field.getText()));
            aluno.getNotas().setNota2(Double.parseDouble(nota2Field.getText()));
            aluno.getNotas().setNota3(Double.parseDouble(nota3Field.getText()));
            aluno.getNotas().setNota4(Double.parseDouble(nota4Field.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Notas adicionadas com sucesso!");
            alert.showAndWait();
            Stage stage = (Stage) salvarButton.getScene().getWindow();
            stage.close();
        }catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, insira valores válidos para as notas.");
            alert.showAndWait();
        }   
    } 
}   