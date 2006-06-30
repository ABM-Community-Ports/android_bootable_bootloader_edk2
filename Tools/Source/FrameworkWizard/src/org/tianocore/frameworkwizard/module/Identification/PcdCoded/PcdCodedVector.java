/** @file
 
 The file is used to define Package Dependencies Vector
 
 Copyright (c) 2006, Intel Corporation
 All rights reserved. This program and the accompanying materials
 are licensed and made available under the terms and conditions of the BSD License
 which accompanies this distribution.  The full text of the license may be found at
 http://opensource.org/licenses/bsd-license.php
 
 THE PROGRAM IS DISTRIBUTED UNDER THE BSD LICENSE ON AN "AS IS" BASIS,
 WITHOUT WARRANTIES OR REPRESENTATIONS OF ANY KIND, EITHER EXPRESS OR IMPLIED.
 
 **/
package org.tianocore.frameworkwizard.module.Identification.PcdCoded;

import java.util.Vector;

public class PcdCodedVector {

    private Vector<PcdCodedIdentification> vPcdCoded = new Vector<PcdCodedIdentification>();

    public int findPcdCoded(PcdCodedIdentification sfi) {
        for (int index = 0; index < vPcdCoded.size(); index++) {
            if (vPcdCoded.elementAt(index).equals(sfi)) {
                return index;
            }
        }
        return -1;
    }

    public int findPcdCoded(String name) {
        for (int index = 0; index < vPcdCoded.size(); index++) {
            if (vPcdCoded.elementAt(index).getName().equals(name)) {
                return index;
            }
        }
        return -1;
    }

    public PcdCodedIdentification getPcdCoded(int index) {
        if (index > -1) {
            return vPcdCoded.elementAt(index);
        } else {
            return null;
        }
    }

    public void addPcdCoded(PcdCodedIdentification arg0) {
        vPcdCoded.addElement(arg0);
    }

    public void updatePcdCoded(PcdCodedIdentification arg0, int arg1) {
        vPcdCoded.setElementAt(arg0, arg1);
    }

    public void removePcdCoded(PcdCodedIdentification arg0) {
        int index = findPcdCoded(arg0);
        if (index > -1) {
            vPcdCoded.removeElementAt(index);
        }
    }

    public void removePcdCoded(int index) {
        if (index > -1 && index < this.size()) {
            vPcdCoded.removeElementAt(index);
        }
    }

    public Vector<PcdCodedIdentification> getvPcdCoded() {
        return vPcdCoded;
    }

    public void setvPcdCoded(Vector<PcdCodedIdentification> PcdCoded) {
        vPcdCoded = PcdCoded;
    }

    public Vector<String> getPcdCodedName() {
        Vector<String> v = new Vector<String>();
        for (int index = 0; index < this.vPcdCoded.size(); index++) {
            v.addElement(vPcdCoded.get(index).getName());
        }
        return v;
    }

    public int size() {
        return this.vPcdCoded.size();
    }

}
