/** @file
  Java class SpdProtocolDecls is GUI for create library definition elements of spd file.
 
Copyright (c) 2006, Intel Corporation
All rights reserved. This program and the accompanying materials
are licensed and made available under the terms and conditions of the BSD License
which accompanies this distribution.  The full text of the license may be found at
http://opensource.org/licenses/bsd-license.php

THE PROGRAM IS DISTRIBUTED UNDER THE BSD LICENSE ON AN "AS IS" BASIS,
WITHOUT WARRANTIES OR REPRESENTATIONS OF ANY KIND, EITHER EXPRESS OR IMPLIED.
**/
package org.tianocore.frameworkwizard.packaging.ui;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.tianocore.PackageSurfaceAreaDocument;

/**
GUI for create library definition elements of spd file.
 
@since PackageEditor 1.0
**/
public class SpdProtocolDecls extends SpdGuidDecls {

    private SpdFileContents sfc = null;
    
    public SpdProtocolDecls() {
        super();
        // TODO Auto-generated constructor stub
    }

    public SpdProtocolDecls(PackageSurfaceAreaDocument.PackageSurfaceArea inPsa) {
        this();
        sfc = new SpdFileContents(inPsa);
        init(sfc);
    }
    
    protected void initFrame() {
        
        this.setTitle("Protocol Declarations");
        getJScrollPaneGuid().setVisible(false);
        getJLabel3().setVisible(false);
        
        getJTable().getColumn("GuidTypes").setPreferredWidth(0);
        getJTable().getColumn("GuidTypes").setWidth(0);
        getJTable().getColumn("GuidTypes").setHeaderValue(" ");
    }
    
    protected void init(SpdFileContents sfc){
        //
        // initialize table using SpdFileContents object
        //
        DefaultTableModel model = getModel();
        if (sfc.getSpdProtocolDeclarationCount() == 0) {
            return ;
        }
        String[][] saa = new String[sfc.getSpdProtocolDeclarationCount()][6];
        sfc.getSpdProtocolDeclarations(saa);
        int i = 0;
        while (i < saa.length) {
            model.addRow(saa[i]);
            i++;
        }
        
    }
    
    protected void updateRow(int row, TableModel m){
        String name = m.getValueAt(row, 0) + "";
        String cName = m.getValueAt(row, 1) + "";
        String guid = m.getValueAt(row, 2) + "";
        String help = m.getValueAt(row, 3) + "";
        String archList = null;
        if (m.getValueAt(row, 4) != null) {
            archList = m.getValueAt(row, 4).toString();
        }
        String modTypeList = null;
        if (m.getValueAt(row, 5) != null) {
            modTypeList = m.getValueAt(row, 5).toString();
        }
        
        sfc.updateSpdProtocolDecl(row, name, cName, guid, help, archList, modTypeList);
    }
    
    protected void addRow(String[] row) {
        sfc.genSpdProtocolDeclarations(row[0], row[1], row[2], row[3], stringToVector(row[4]), stringToVector(row[5]));
    }
    
    protected void removeRow(int i){
        sfc.removeSpdProtocolDeclaration(i);
    }
    
    protected void clearAllRow(){
        sfc.removeSpdProtocolDeclaration();
    }
}
