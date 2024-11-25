package view;

import interface_adapter.edit_profile.EditProfileController;
import interface_adapter.edit_profile.EditProfileState;
import interface_adapter.edit_profile.EditProfileViewModel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The View for when the user is logging into the program.
 */
public class EditProfileView extends JPanel implements PropertyChangeListener {

    private final String viewName = "edit profile";
    private final EditProfileViewModel editprofileViewModel;

    private final JTextField nameInputFieldDocument = new JTextField(15);
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
                new JLabel("Name"), nameInputFieldDocument);
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
                                    currentState.getName(),
                                    currentState.getGender()
                            );
                        }
                    }
                }
        );

        logout.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(logout)) {
                        final EditProfileState currentState = editprofileViewModel.getState();
                        this.editprofileController.execute(currentState.getName(), currentState.getGender());
                    }
                }
        );
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
//        nameInputFieldDocument.getDocument().addDocumentListener(new DocumentListener() {
//
//            private void documentListenerHelper() {
//                final EditProfileState currentState = EditProfileViewModel.getState();
//                currentState.setName(nameInputFieldDocument.getText());
//                EditProfileViewModel.setState(currentState);
//            }
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//        });
//
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

//        GenderInputField.getDocument().addDocumentListener(new DocumentListener() {
//
//            private void documentListenerHelper() {
//                final EditProfileState currentState = editprofileViewModel.getState();
//                currentState.setGender(new String(GenderInputField.getText()));
//                editprofileViewModel.setState(currentState);
//            }

//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//        });

//        this.add(title);
//        this.add(NameInfo);
//        this.add(NameErrorField);
//        this.add(PasswordInfo);
//        this.add(buttons);
//    }
//
//    /**
//     * React to a button click that results in evt.
//     * @param evt the ActionEvent to react to
//     */
//    public void actionPerformed(ActionEvent evt) {
//        System.out.println("Click " + evt.getActionCommand());
//    }

//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        final LoginState state = (LoginState) evt.getNewValue();
//        setFields(state);
//        NameErrorField.setText(state.getLoginError());
//    }

//    private void setFields(EditProfileState state) {
//        NameInputField.setText(state.getname());
//        GenderInputField.setText(state.getgender());
//    }

//    public String getViewName() {
//        return viewName;
//    }
//
//    public void setLoginController(EditProfileController editprofileController) {
//        this.editprofileController = editprofileController;
//    }
//  }
//