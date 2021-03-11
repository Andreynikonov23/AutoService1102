package ru.sapteh.controller;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.DAO;
import ru.sapteh.daoImpl.ClientDAOImpl;
import ru.sapteh.model.Client;

import java.util.Date;
import java.util.List;

public class MainController {

    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    ObservableList<Client> observableList = FXCollections.observableArrayList();

    @FXML
    private Button buttonNew;

    @FXML
    private Button buttonUpdate;

    @FXML
    private Button columnDelete;

    @FXML
    private TableView<Client> tableView;

    @FXML
    private TableColumn<Client, Integer> columnId;

    @FXML
    private TableColumn<Client, String> columnFirstname;

    @FXML
    private TableColumn<Client, String> columnLastname;

    @FXML
    private TableColumn<Client, String> columnPatronymic;

    @FXML
    private TableColumn<Client, Date> columnBirthday;

    @FXML
    private TableColumn<Client, Date> columnRegistrationDate;

    @FXML
    private TableColumn<Client, String> columnEmail;

    @FXML
    private TableColumn<Client, String> columnPhone;

    @FXML
    private TableColumn<Client, String> columnGender;

    @FXML
    private TableColumn<Client, String> columnMainImagePhoto;

    @FXML
    void initialize() {
        DAO<Client, Integer> clientIntegerDAO = new ClientDAOImpl(factory);
        observableList.addAll(clientIntegerDAO.findByAll());


        columnId.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getId()));
        columnFirstname.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getFirstname()));
        columnLastname.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getFirstname()));
        columnBirthday.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getBirthday()));
        columnEmail.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getEmail()));
        columnPatronymic.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPatronymic()));
        columnGender.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getGender().getName()));
        columnMainImagePhoto.setCellValueFactory(a -> new SimpleObjectProperty<>(a.getValue().getPhotoPath()));


        tableView.setItems(observableList);

    }
}
