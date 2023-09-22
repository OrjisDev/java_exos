package Exercices4;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private GUI() {
        //Création de la fenêtre avec le nom de cette dernière.
        super("Database management");
        //Propriétés de la fenêtre : Le programme se ferme à l'appui du bouton X et la résolution est de 600x500.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);

        // Construction et injection de la barre de menu
        this.setJMenuBar( this.menuBar() );
    }

    private JPanel createUserPanel(){
        JPanel createUserPanel = new JPanel(new GridLayout(4,2));
        JLabel username = new JLabel("Nom d'utilisateur : ");
        JTextField setUsername =  new JTextField(20);
        JLabel password = new JLabel("Mot de passe : ");
        JTextField setPassword = new JPasswordField(20);
        JLabel email = new JLabel("Adresse mail : ");
        JTextField setEmail = new JTextField(20);
        JButton submitButton = new JButton("Soumettre");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAO_CRUD.addUser(new User(setUsername.getText(),setPassword.getText(),setEmail.getText()));
            }
        });
        createUserPanel.add(username);
        createUserPanel.add(setUsername);
        createUserPanel.add(password);
        createUserPanel.add(setPassword);
        createUserPanel.add(email);
        createUserPanel.add(setEmail);
        createUserPanel.add(submitButton);
        return createUserPanel;
    }

    private JPanel updateUserPanel(){
        JPanel updateUserPanel = new JPanel(new GridLayout(5,2));
        JLabel username = new JLabel("Nom d'utilisateur : ");
        JTextField setUsername =  new JTextField(20);
        JLabel password = new JLabel("Mot de passe : ");
        JTextField setPassword = new JPasswordField(20);
        JLabel email = new JLabel("Adresse mail : ");
        JTextField setEmail = new JTextField(20);
        JLabel id = new JLabel("Identifiant utilisateur : ");
        JTextField setId = new JTextField(20);
        JButton submitButton = new JButton("Soumettre");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAO_CRUD.updateUser(setUsername.getText(),setPassword.getText(),setEmail.getText(),Integer.parseInt(setId.getText()));
            }
        });
        updateUserPanel.add(username);
        updateUserPanel.add(setUsername);
        updateUserPanel.add(password);
        updateUserPanel.add(setPassword);
        updateUserPanel.add(email);
        updateUserPanel.add(setEmail);
        updateUserPanel.add(submitButton);
        return updateUserPanel;
    }



    private JPanel deleteUserPanel() {
        JPanel deleteUserPanel = new JPanel(new GridLayout(4, 2));
        JLabel id = new JLabel("Identifiant utilisateur : ");
        JTextField setId = new JTextField(20);
        JButton submitButton = new JButton("Soumettre");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DAO_CRUD.deleteUser(Integer.parseInt(setId.getText()));
            }
        });
        deleteUserPanel.add(id);
        deleteUserPanel.add(setId);
        deleteUserPanel.add(submitButton);
        return deleteUserPanel;
    }

    private JMenuBar menuBar(){

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        cardPanel.add(createUserPanel(), "addUserPanel");
        cardPanel.add(updateUserPanel(), "updateUserPanel");
        cardPanel.add(deleteUserPanel(), "deletePanel");


        //Création du menu de navigation
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        JMenu menuOperations = new JMenu("Opérations sur la BDD");

        //Je crée les boutons du menu en implémentant des icônes et des Mnemnonic qui permettent d'aller plus vite dans les menus.

        //Ajouter un utilisateur
        JMenuItem newUser = new JMenuItem("Ajouter nouveau utilisateur");
        ImageIcon addIcon = new ImageIcon("icons/add-icon.png");
        newUser.setMnemonic('A');
        newUser.setIcon(addIcon);
        newUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel,"addUserPanel");

            }
        });

        //Chercher un utilisateur
        JMenuItem searchUser = new JMenuItem("Chercher un utilisateur");
        ImageIcon searchIcon = new ImageIcon("icons/search-icon.png");
        searchUser.setMnemonic('C');
        searchUser.setIcon(searchIcon);
        searchUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "");
            }
        });

        //Mettre à jour un utilisateur
        JMenuItem updateUser = new JMenuItem("Mettre a jour un utilisateur");
        ImageIcon updateIcon = new ImageIcon("icons/update-icon.png");
        updateUser.setMnemonic('M');
        updateUser.setIcon(updateIcon);
        searchUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "updateUser");
            }
        });

        //Supprimer un utilisateur
        JMenuItem deleteUser = new JMenuItem("Supprimer un utilisateur");
        ImageIcon deleteIcon = new ImageIcon("icons/delete-icon.png");
        deleteUser.setMnemonic('S');
        deleteUser.setIcon(deleteIcon);
        deleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "deleteUser");
            }
        });

        //Ajout des Items du menu au menu puis implémentation dans la fenêtre.
        menuOperations.add(newUser);
        menuOperations.add(searchUser);
        menuOperations.add(updateUser);
        menuOperations.add(deleteUser);
        menuBar.add(menuOperations);

        getContentPane().add(cardPanel,BorderLayout.CENTER);

        return menuBar;

    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );
        GUI window = new GUI();
        window.setVisible(true);
    }

}