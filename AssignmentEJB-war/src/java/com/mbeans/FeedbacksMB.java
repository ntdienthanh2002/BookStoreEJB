/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mbeans;

import com.entitybean.Feedbacks;
import com.sessionbean.FeedbacksFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author OS
 */
@Named(value = "feedbacksMB")
@RequestScoped
public class FeedbacksMB {

    @EJB
    private FeedbacksFacadeLocal feedbacksFacade;

    public FeedbacksMB() {
    }
    
    public List<Feedbacks> showAllFeedbacks() {
        return feedbacksFacade.findAll();
    }
}
