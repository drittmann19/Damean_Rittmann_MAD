//
//  ViewController.swift
//  Lab1
//
//  Created by Damean Rittmann on 9/8/20.
//  Copyright © 2020 Damean Rittmann. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var artImage: UIImageView!
    
    @IBOutlet weak var artName: UILabel!
    
    @IBAction func chooseArt(_ sender: UIButton) {
        if sender.tag == 0{
            artImage.image = UIImage(named: "starryNight")
            artName.text = "Starry Night"
        }else if sender.tag == 1{
            artImage.image = UIImage(named: "impressionSunrise")
            artName.text = "Impression Sunrise"
        }else if sender.tag == 2{
            artImage.image = UIImage(named: "weepingWoman")
            artName.text = "Weeping Woman"
        }
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

