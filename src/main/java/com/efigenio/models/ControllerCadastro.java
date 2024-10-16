package com.efigenio.models;
//import com.efigenio.models;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;


import java.io.*;

public class ControllerCadastro {
    @FXML
    private TextField nomeField;
    @FXML
    private TextField nascimentoField;
    @FXML
    private TextField cpfField;
    @FXML
    private TextField emailField;
    @FXML
    private Button adicionarButton;
    @FXML
    private Button listaButton;

    @FXML
    private void initialize() {
        adicionarButton.setOnAction(e -> adicionarAluno());
        listaButton.setOnAction(e -> abrirListaAlunos());
    }

    private void adicionarAluno() {
        String nome = nomeField.getText();
        String nascimento = nascimentoField.getText();
        String cpf = cpfField.getText();
        String email = emailField.getText();

        Aluno aluno = new Aluno(nome, nascimento, cpf, email);
        salvarAluno(aluno);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Aluno adicionado com sucesso!");
        alert.showAndWait();

        nomeField.clear();
        nascimentoField.clear();
        cpfField.clear();
        emailField.clear();
    }

    private void salvarAluno(Aluno aluno) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("alunos.txt", true))) {
            oos.writeObject(aluno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirListaAlunos() {
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/lista_alunos.fxml"));
            stage.setTitle("Lista de Alunos");
            stage.setScene(new Scene(root, 400, 300));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
