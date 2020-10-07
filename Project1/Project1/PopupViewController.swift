//
//  PopupViewController.swift
//  Project1
//
//  Created by Damean Rittmann on 10/1/20.
//  Copyright © 2020 Damean Rittmann. All rights reserved.
//

import UIKit

class PopupViewController: UIViewController {

    var mealArray = [Int]()
    var mealNum = 0 //number of meal, 1-slider num
    var pictureNum = 0 //number of the key to the picture of the meals
    var frontPictures = [1: "honeyChickenFront",
                        2: "kaleRavioliFront",
                        3: "fajitasFront",
                        4: "sausageRavioliFront",
                        5: "bbqBurgerFront",
                        6: "carnitasTacoFront",
                        7: "meatballPastaFront",
                        8: "bologneseFront",
                        9: "bibimbapFront",
                        10: "tacoFlatbreadFront",
                        11: "hoisinMeatballFront",
                        12: "thymeSteakFront",
                        13: "sesameTacoFront",
                        14: "bbqFlatbreadFront",
                        15: "gardenRavioliFront",
                        16: "paniniFront",
                        17: "cavatappiFront",
                        18: "lemonRavioliFront"]
    
    var backPictures = [1: "honeyChickenBack",
                        2: "kaleRavioliBack",
                        3: "fajitasBack",
                        4: "sausageRavioliBack",
                        5: "bbqBurgerBack",
                        6: "carnitasTacoBack",
                        7: "meatballPastaBack",
                        8: "bologneseBack",
                        9: "bibimbapBack",
                        10: "tacoFlatbreadBack",
                        11: "hoisinMeatballBack",
                        12: "thymeSteakBack",
                        13: "sesameTacoBack",
                        14: "bbqFlatbreadBack",
                        15: "gardenRavioliBack",
                        16: "paniniBack",
                        17: "cavatappiBack",
                        18: "lemonRavioliBack"]
    
    
    @IBOutlet weak var frontImage: UIImageView!
    @IBOutlet weak var backImage: UIImageView!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        dump(mealArray)
        pictureNum = mealArray[mealNum]
        frontImage.image=UIImage(named: frontPictures[pictureNum]!)
        backImage.image = UIImage(named: backPictures[pictureNum]!)

        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}
