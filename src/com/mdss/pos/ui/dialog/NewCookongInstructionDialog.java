package com.mdss.pos.ui.dialog;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;

import net.miginfocom.swing.MigLayout;

import com.mdss.pos.model.CookingInstruction;
import com.mdss.pos.model.dao.CookingInstructionDAO;
import com.mdss.pos.swing.PosButton;
import com.mdss.pos.ui.views.NoteView;

public class NewCookongInstructionDialog extends POSDialog implements ActionListener {
	private CookingInstruction cookingInstruction;
	
	private NoteView noteView;
	private PosButton btnOk;
	private PosButton btnCancel;

	public NewCookongInstructionDialog() throws HeadlessException {
		super();
	}

	public NewCookongInstructionDialog(Dialog owner, boolean modal) {
		super(owner, modal);
	}

	public NewCookongInstructionDialog(Dialog owner, String title, boolean modal) {
		super(owner, title, modal);
	}

	public NewCookongInstructionDialog(Frame owner, boolean modal, boolean unDecorated) throws HeadlessException {
		super(owner, modal, unDecorated);
	}

	public NewCookongInstructionDialog(Frame owner, boolean modal) throws HeadlessException {
		super(owner, modal);
	}
	
	@Override
	protected void initUI() {
		setLayout(new MigLayout());
		
		noteView = new NoteView();
		btnOk = new PosButton("OK");
		btnCancel = new PosButton("CANCEL");
		add(noteView, "wrap, span, grow");
		add(new JSeparator(), "wrap, span, grow");
		add(btnOk, "al right,width 120, height 50");
		add(btnCancel, "width 120, height 50");
		
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
	}
	
	public String getText() {
		return noteView.getNote();
	}
	
	private void doOk() {
		if(cookingInstruction == null) {
			cookingInstruction = new CookingInstruction();
		}
		cookingInstruction.setDescription(getText());
		
		CookingInstructionDAO dao = new CookingInstructionDAO();
		dao.save(cookingInstruction);
		
		setCanceled(false);
		dispose();
	}

	private void doCancel() {
		setCanceled(true);
		dispose();
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		if("OK".equalsIgnoreCase(actionCommand)) {
			doOk();
		}
		else if("CANCEL".equalsIgnoreCase(actionCommand)) {
			doCancel();
		}
	}

	public CookingInstruction getCookingInstruction() {
		return cookingInstruction;
	}

}