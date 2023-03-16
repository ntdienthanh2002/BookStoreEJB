/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.Publishers;
import com.sessionbean.PublishersFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author OS
 */
@Named(value = "publishersMB")
@RequestScoped
public class PublishersMB {

    @EJB
    private PublishersFacadeLocal publishersFacade;

    private Publishers publishers;
    private int idPublisher;
    
    public PublishersMB() {
        publishers = new Publishers();
    }

    public List<Publishers> showAllPublishers() {
        return publishersFacade.findAll();
    }
    
    public String insertPublisher() {
        publishersFacade.create(publishers);
        return "publishers";
    }
    
    public String showUpdatePublisherForm(int id) {
        publishers = publishersFacade.find(id);
        idPublisher = publishers.getPublisherID();
        return "publisher_update";
    }
    
    public String updatePublisher() {
        Publishers pu = publishersFacade.find(idPublisher);
        pu.setPublisherName(publishers.getPublisherName());
        publishersFacade.edit(pu);
        return "publishers";
    }
    
    public String deletePublisher(int id) {
        publishersFacade.remove(publishersFacade.find(id));
        return "publishers";
    }
    
    public Publishers getPublishers() {
        return publishers;
    }

    public void setPublishers(Publishers publishers) {
        this.publishers = publishers;
    }

    public int getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(int idPublisher) {
        this.idPublisher = idPublisher;
    }
    
}
