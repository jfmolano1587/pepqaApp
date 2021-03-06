/* ========================================================================
 * Copyright 2014 PepqaAppV1
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 PepqaAppV1

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201411201032

*/

package co.edu.uniandes.csw.PepqaAppV1.pepqaapp.master.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.PepqaAppV1.pepqaapp.master.logic.api.IPepqaAppMasterLogicService;
import co.edu.uniandes.csw.PepqaAppV1.pepqaapp.master.logic.dto.PepqaAppMasterDTO;

public abstract class _PepqaAppMasterService {

    @Inject
    protected IPepqaAppMasterLogicService pepqaappLogicService;

    @POST
    public PepqaAppMasterDTO createPepqaApp(PepqaAppMasterDTO pepqaapp) {
        return pepqaappLogicService.createMasterPepqaApp(pepqaapp);
    }

    @DELETE
    @Path("{id}")
    public void deletePepqaApp(@PathParam("id") Long id) {
        pepqaappLogicService.deleteMasterPepqaApp(id);
    }
    
    @GET
    @Path("{id}")
    public PepqaAppMasterDTO getPepqaApp(@PathParam("id") Long id) {
        return pepqaappLogicService.getMasterPepqaApp(id);
    }

    @PUT
    @Path("{id}")
    public void updatePepqaApp(@PathParam("id") Long id, PepqaAppMasterDTO pepqaapp) {
        pepqaappLogicService.updateMasterPepqaApp(pepqaapp);
    }

}
