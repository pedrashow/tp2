/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista3_q6;

import java.util.ArrayList;

/**
 *
 * @author beto
 */
public class GerenciaDeQuartos {
    
    /**
     * listar ocupação, quartos com cama livre e camas ocupadas por quais clientes
     * solicitar ocupação em quarto simples/luxo
     * realizar checkout
     * rodar diárias
     * listar hospedagens por cliente
     */
    
    public ArrayList <Cama> camas = new ArrayList<>();
    public ArrayList <Diaria> diarias = new ArrayList<>();
    public ArrayList <Cliente> clientes = new ArrayList<>();
    public ArrayList <Quarto> quartos = new ArrayList<>();
    
     
    public static void cadastraQuarto() {
        //Simples, Luxo Pequeno, Luxo grande : id
    }

    public static void cadastraCama() {
        //id.. depois associar a um quarto
    }
    
    public static void cadastraCliente() {
        //nome
    }
    
    public static void fazerCheckin() {
        //cliente, cama
    }
    
}
