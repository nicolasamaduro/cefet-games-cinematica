/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.math.Vector3;

/**
 *
 * @author nicolas
 */
public class Chegar extends Algoritmo  {

    private static final char NOME ='c';
    
    
    public Chegar(float maxVelocidade) {
        super(NOME);
        this.maxVelocidade=maxVelocidade;
    }

    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        Vector3 objetivo = new Vector3(this.alvo.getObjetivo());
        Vector3 velocidade = objetivo.sub(agente.posicao);
        if (velocidade.len2()>3000){
            output.velocidade = velocidade.clamp(maxVelocidade, maxVelocidade);
        }else{
          output.velocidade = velocidade.clamp(0, maxVelocidade/2);
        }
        return output;
    }
    
}
