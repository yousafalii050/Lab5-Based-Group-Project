package view;

import interface_adapter.change_password.LoggedInState;
import interface_adapter.edit_profile.EditProfileState;
import interface_adapter.edit_profile.EditProfileViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;

/**
 * The View for when the user is logging into the program.
 */
public class EditProfileView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "edit profile";
    private final EditProfileViewModel editprofileViewModel;

    private final JTextField NameInputField = new JTextField(15);
    private final JLabel NameErrorField = new JLabel();

    private final JTextField GenderInputField = new JTextField(15);
    private final JLabel GenderErrorField = new JLabel();

    private final JButton confirmedits;
    private final JButton logout;
    private EditProfileController editprofileController;

    public EditProfileView(EditProfileViewModel editprofileViewModel) {

        this.editprofileViewModel = editprofileViewModel;
        this.editprofileViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Edit Profile Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final LabelTextPanel changename = new LabelTextPanel(
                new JLabel("Name"), NameInputField);
        final LabelTextPanel changegender = new LabelTextPanel(
                new JLabel("Gender"), GenderInputField);

        final JPanel buttons = new JPanel();
        confirmedits = new JButton("Confirm Edits");
        buttons.add(confirmedits);
        logout = new JButton("Log Out");
        buttons.add(logout);

        confirmedits.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(confirmedits)) {
                            final EditProfileState currentState = editprofileViewModel.getState();

                            editprofileController.execute(
                                    currentState.getname(),
                                    currentState.getgender()
                            );
                        }
                    }
                }
        );

        logout.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(logout)) {
                        final LoggedInState currentState = EditProfileViewModel.getState();
                        this.editprofileController.execute(currentState.getname());

        NameInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoginState currentState = EditProfileViewModel.getState();
                currentState.setname(NameInputField.getText());
                EditProfileViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        GenderInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoginState currentState = editprofileViewModel.getState();
                currentState.setgender(new String(GenderInputField.getgender()));
                editprofileViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        this.add(title);
        this.add(NameInfo);
        this.add(NameErrorField);
        this.add(PasswordInfo);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
        NameErrorField.setText(state.getLoginError());
    }

    private void setFields(EditProfileState state) {
        NameInputField.setText(state.getname());
        GenderInputField.setText(state.getgender());
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoginController(EditProfileController editprofileController) {
        this.editprofileController = editprofileController;
    }
}

