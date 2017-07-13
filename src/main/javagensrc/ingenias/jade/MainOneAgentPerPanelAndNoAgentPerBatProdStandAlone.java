/*
 Copyright (C) 2005 Jorge Gomez Sanz

 This file is part of INGENIAS Agent Framework, an agent infrastructure linked
 to the INGENIAS Development Kit, and availabe at http://grasia.fdi.ucm.es/ingenias or
 http://ingenias.sourceforge.net. 

 INGENIAS Agent Framework is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.

 INGENIAS Agent Framework is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with INGENIAS Agent Framework; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

 */

package ingenias.jade;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.net.UnknownHostException;

import jade.core.*;
import ingenias.jade.mental.*;

import ingenias.jade.graphics.MainInteractionManager;

public class MainOneAgentPerPanelAndNoAgentPerBatProdStandAlone {

	public static void main(String args[]) throws Exception {
		IAFProperties.setGraphicsOn(false);
		String jadelogfolder = "target/jade";
		if (!(new File(jadelogfolder).exists() && new File(jadelogfolder)
				.isDirectory())) {
			// from
			// http://stackoverflow.com/questions/617414/create-a-temporary-directory-in-java
			final File temp;
			temp = File
					.createTempFile("jade", Long.toString(System.nanoTime()));

			if (!(temp.delete())) {
				throw new IOException("Could not delete temp file: "
						+ temp.getAbsolutePath());
			}

			if (!(temp.mkdir())) {
				throw new IOException("Could not create temp directory: "
						+ temp.getAbsolutePath());
			}
			jadelogfolder = temp.getAbsolutePath() + "/";
		}
		final String finalJadeLogFolder = jadelogfolder;
		new Thread() {
			public void run() {
				String[] args1 = new String[4];
				args1[0] = "-port";
				args1[1] = "60000";
				args1[2] = "-file-dir";
				args1[3] = finalJadeLogFolder;
				jade.Boot.main(args1);
			}
		}.start();

		// Get a hold on JADE runtime
		jade.core.Runtime rt = jade.core.Runtime.instance();

		// Exit the JVM when there are no more containers around
		rt.setCloseVM(true);

		// Create a default profile
		Profile p = new ProfileImpl();
		p.setParameter("preload", "a*");
		p.setParameter(Profile.MAIN_PORT, "60000");
		p.setParameter(Profile.FILE_DIR, jadelogfolder);

		// Waits for JADE to start
		boolean notConnected = true;

		while (notConnected) {
			try {
				Socket s = new Socket("localhost", Integer.parseInt("60000"));
				notConnected = false;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {

				System.err.println("Error: " + e.getMessage());
				System.err.println("Reconnecting in one second");
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}

		// Create a new non-main container, connecting to the default
		// main container (i.e. on this host, port 1099)
		final jade.wrapper.AgentContainer ac = rt.createAgentContainer(p);

		{
			// Create a new agent
			final jade.wrapper.AgentController agcPV_Controller_0DeploymentUnitByTypeMSEntity2 = ac
					.createNewAgent(
							"PV_Controller_0DeploymentUnitByTypeMSEntity2",
							"ingenias.jade.agents.PV_ControllerJADEAgent",
							new Object[0]);

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_312");

				agcPV_Controller_0DeploymentUnitByTypeMSEntity2.putO2AObject(
						ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Controller_0DeploymentUnitByTypeMSEntity2.putO2AObject(
						ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Controller_0DeploymentUnitByTypeMSEntity2...");
						agcPV_Controller_0DeploymentUnitByTypeMSEntity2.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

			// Create a new agent
			final jade.wrapper.AgentController agcPV_Controller_0DeploymentUnitByTypeMSEntity1 = ac
					.createNewAgent(
							"PV_Controller_0DeploymentUnitByTypeMSEntity1",
							"ingenias.jade.agents.PV_ControllerJADEAgent",
							new Object[0]);

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_11");

				agcPV_Controller_0DeploymentUnitByTypeMSEntity1.putO2AObject(
						ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Controller_0DeploymentUnitByTypeMSEntity1.putO2AObject(
						ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Controller_0DeploymentUnitByTypeMSEntity1...");
						agcPV_Controller_0DeploymentUnitByTypeMSEntity1.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

			// Create a new agent
			final jade.wrapper.AgentController agcPV_Controller_0DeploymentUnitByTypeMSEntity6 = ac
					.createNewAgent(
							"PV_Controller_0DeploymentUnitByTypeMSEntity6",
							"ingenias.jade.agents.PV_ControllerJADEAgent",
							new Object[0]);

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_21");

				agcPV_Controller_0DeploymentUnitByTypeMSEntity6.putO2AObject(
						ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Controller_0DeploymentUnitByTypeMSEntity6.putO2AObject(
						ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Controller_0DeploymentUnitByTypeMSEntity6...");
						agcPV_Controller_0DeploymentUnitByTypeMSEntity6.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

			// Create a new agent
			final jade.wrapper.AgentController agcPV_Controller_0DeploymentUnitByTypeMSEntity5 = ac
					.createNewAgent(
							"PV_Controller_0DeploymentUnitByTypeMSEntity5",
							"ingenias.jade.agents.PV_ControllerJADEAgent",
							new Object[0]);

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_222");

				agcPV_Controller_0DeploymentUnitByTypeMSEntity5.putO2AObject(
						ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Controller_0DeploymentUnitByTypeMSEntity5.putO2AObject(
						ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Controller_0DeploymentUnitByTypeMSEntity5...");
						agcPV_Controller_0DeploymentUnitByTypeMSEntity5.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

			// Create a new agent
			final jade.wrapper.AgentController agcPV_Controller_0DeploymentUnitByTypeMSEntity4 = ac
					.createNewAgent(
							"PV_Controller_0DeploymentUnitByTypeMSEntity4",
							"ingenias.jade.agents.PV_ControllerJADEAgent",
							new Object[0]);

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_221");

				agcPV_Controller_0DeploymentUnitByTypeMSEntity4.putO2AObject(
						ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Controller_0DeploymentUnitByTypeMSEntity4.putO2AObject(
						ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Controller_0DeploymentUnitByTypeMSEntity4...");
						agcPV_Controller_0DeploymentUnitByTypeMSEntity4.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

			// Create a new agent
			final jade.wrapper.AgentController agcPV_Controller_0DeploymentUnitByTypeMSEntity3 = ac
					.createNewAgent(
							"PV_Controller_0DeploymentUnitByTypeMSEntity3",
							"ingenias.jade.agents.PV_ControllerJADEAgent",
							new Object[0]);

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_311");

				agcPV_Controller_0DeploymentUnitByTypeMSEntity3.putO2AObject(
						ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Controller_0DeploymentUnitByTypeMSEntity3.putO2AObject(
						ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Controller_0DeploymentUnitByTypeMSEntity3...");
						agcPV_Controller_0DeploymentUnitByTypeMSEntity3.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

		}
		MainInteractionManager.getInstance().setTitle(
				"node OneAgentPerPanelAndNoAgentPerBat");
	}
}
