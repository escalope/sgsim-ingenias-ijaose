
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
import java.util.*;

import jade.core.*;
import ingenias.jade.mental.*;

import ingenias.jade.graphics.MainInteractionManager;

public class MainTokenizedDeployment {

	public static void main(String args[]) throws Exception {

		// Get a hold on JADE runtime
		jade.core.Runtime rt = jade.core.Runtime.instance();

		// Exit the JVM when there are no more containers around
		rt.setCloseVM(true);

		// Create a default profile
		Profile p = new ProfileImpl();
		p.setParameter("preload", "a*");
		p.setParameter(Profile.MAIN_PORT, "60000");
		if (args.length == 2 && args[1].equalsIgnoreCase("pause")) {
			ingenias.jade.graphics.MainInteractionManager.goManual();
		}
		if (new File("target/jade").exists()
				&& new File("target/jade").isDirectory())
			p.setParameter(Profile.FILE_DIR, "target/jade/");
		else {
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
			p.setParameter(Profile.FILE_DIR, temp.getAbsolutePath() + "/");
		}

		// Create a new non-main container, connecting to the default
		// main container (i.e. on this host, port 1099)
		final jade.wrapper.AgentContainer ac = rt.createAgentContainer(p);

		{
			// Create a new agent
			final jade.wrapper.AgentController agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity14 = ac
					.createNewAgent(
							"PV_Token_based_controller_0DeploymentUnitByTypeMSEntity14",
							"ingenias.jade.agents.PV_Token_based_controllerJADEAgent",
							new Object[0]);

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_21");

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity14
						.putO2AObject(ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity14
						.putO2AObject(ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Token_based_controller_0DeploymentUnitByTypeMSEntity14...");
						agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity14
								.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

			// Create a new agent
			final jade.wrapper.AgentController agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity13 = ac
					.createNewAgent(
							"PV_Token_based_controller_0DeploymentUnitByTypeMSEntity13",
							"ingenias.jade.agents.PV_Token_based_controllerJADEAgent",
							new Object[0]);

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_222");

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity13
						.putO2AObject(ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity13
						.putO2AObject(ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Token_based_controller_0DeploymentUnitByTypeMSEntity13...");
						agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity13
								.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

			// Create a new agent
			final jade.wrapper.AgentController agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity12 = ac
					.createNewAgent(
							"PV_Token_based_controller_0DeploymentUnitByTypeMSEntity12",
							"ingenias.jade.agents.PV_Token_based_controllerJADEAgent",
							new Object[0]);

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_221");

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity12
						.putO2AObject(ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity12
						.putO2AObject(ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Token_based_controller_0DeploymentUnitByTypeMSEntity12...");
						agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity12
								.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

			// Create a new agent
			final jade.wrapper.AgentController agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity11 = ac
					.createNewAgent(
							"PV_Token_based_controller_0DeploymentUnitByTypeMSEntity11",
							"ingenias.jade.agents.PV_Token_based_controllerJADEAgent",
							new Object[0]);

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_311");

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity11
						.putO2AObject(ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity11
						.putO2AObject(ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Token_based_controller_0DeploymentUnitByTypeMSEntity11...");
						agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity11
								.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

			// Create a new agent
			final jade.wrapper.AgentController agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity10 = ac
					.createNewAgent(
							"PV_Token_based_controller_0DeploymentUnitByTypeMSEntity10",
							"ingenias.jade.agents.PV_Token_based_controllerJADEAgent",
							new Object[0]);

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_312");

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity10
						.putO2AObject(ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity10
						.putO2AObject(ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Token_based_controller_0DeploymentUnitByTypeMSEntity10...");
						agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity10
								.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

			// Create a new agent
			final jade.wrapper.AgentController agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity9 = ac
					.createNewAgent(
							"PV_Token_based_controller_0DeploymentUnitByTypeMSEntity9",
							"ingenias.jade.agents.PV_Token_based_controllerJADEAgent",
							new Object[0]);

			{
				Token ment = new Token();

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity9
						.putO2AObject(ment, false);
			}

			{
				AssociatedUnit ment = new AssociatedUnit();

				ment.setdevice("Solar_11");

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity9
						.putO2AObject(ment, false);
			}

			{
				OrdersHistory ment = new OrdersHistory();

				ment.setHistory(new java.util.Vector<mired.ucm.Pair<Long, mired.ucm.remote.orders.RemoteOrder>>());

				agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity9
						.putO2AObject(ment, false);
			}

			new Thread() {
				public void run() {
					try {
						System.out
								.println("Starting up PV_Token_based_controller_0DeploymentUnitByTypeMSEntity9...");
						agcPV_Token_based_controller_0DeploymentUnitByTypeMSEntity9
								.start();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}.start();

		}
		MainInteractionManager.getInstance().setTitle(
				"node TokenizedDeployment");
	}
}
