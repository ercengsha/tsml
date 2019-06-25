/*
 * Copyright (C) 2019 xmw13bzu
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package CawpeExtensionPaper;

import experiments.Experiments;
import vector_classifiers.CAWPE;
import weka.classifiers.Classifier;

/**
 *
 * @author James Large (james.large@uea.ac.uk)
 */
public class CAWPEClassifierList {
    
    //copied from experiments.DataSets.ReducedUCI to have as a permanantly fixed list here
    //this is the 39 datasets left of when removing toy, heavily related etc datasets from the 
    //delgado 121. first decided upon in tony rotf paper
    public static final String[] datasetList = {"bank","blood","breast-cancer-wisc-diag",
        "breast-tissue","cardiotocography-10clases", 
        "conn-bench-sonar-mines-rocks","conn-bench-vowel-deterding",
        "ecoli","glass","hill-valley",
        "image-segmentation","ionosphere","iris","libras","magic",
        "miniboone",
        "oocytes_merluccius_nucleus_4d","oocytes_trisopterus_states_5b",
        "optical","ozone","page-blocks","parkinsons","pendigits",
        "planning","post-operative","ringnorm","seeds","spambase",
            "statlog-landsat","statlog-shuttle","statlog-vehicle","steel-plates",
            "synthetic-control","twonorm","vertebral-column-3clases",
            "wall-following","waveform-noise","wine-quality-white","yeast"};
    
    
    public static final String[] all_ensembles = { 
        "CAWPE", 
        "CAWPE_retrain_noWeight", 
        "CAWPE_retrain_foldWeight", 
        "CAWPE_noRetrain" 
    };
    
    public static Classifier setClassifier(Experiments.ExperimentalArguments exp) {        
        return setClassifier(exp.classifierName, exp.foldId);
    }
    
    public static Classifier setClassifier(String classifier, int fold) {                
        switch(classifier){
            
            case "CAWPE": 
                CAWPE cawpe_base = new CAWPE();
                cawpe_base.setRandSeed(fold);
                cawpe_base.setPerformCV(false);
                return cawpe_base;
            
            case "CAWPE_retrain_noWeight": 
                CAWPE_Extended cawpe_retrain_noWeight = new CAWPE_Extended();
                cawpe_retrain_noWeight.setRandSeed(fold);
                cawpe_retrain_noWeight.setPerformCV(false);
                cawpe_retrain_noWeight.setSubModulePriorWeightingScheme(CAWPE_Extended.priorScheme_none);
                cawpe_retrain_noWeight.setRetrainOnFullTrainSet(true);
                return cawpe_retrain_noWeight;
            
            case "CAWPE_retrain_foldWeight": 
                CAWPE_Extended cawpe_retrain_foldWeight = new CAWPE_Extended();
                cawpe_retrain_foldWeight.setRandSeed(fold);
                cawpe_retrain_foldWeight.setPerformCV(false);
                cawpe_retrain_foldWeight.setSubModulePriorWeightingScheme(CAWPE_Extended.priorScheme_oneOverNumFolds);
                cawpe_retrain_foldWeight.setRetrainOnFullTrainSet(true);
                return cawpe_retrain_foldWeight;
            
            case "CAWPE_noRetrain": 
                CAWPE_Extended cawpe_noRetrain = new CAWPE_Extended();
                cawpe_noRetrain.setRandSeed(fold);
                cawpe_noRetrain.setPerformCV(false);
                cawpe_noRetrain.setSubModulePriorWeightingScheme(CAWPE_Extended.priorScheme_none); //irrelevant, all submodules will have same prior
                cawpe_noRetrain.setRetrainOnFullTrainSet(false);
                return cawpe_noRetrain;
                
                
                
                
            default:
                System.out.println("UNKNOWN CLASSIFIER "+classifier);
                System.exit(0);
//                throw new Exception("Unknown classifier "+classifier);
                
        }
        
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(datasetList.length);
    }
}