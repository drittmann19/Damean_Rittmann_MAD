//
//  ViewController.swift
//  Lab3
//
//  Created by Damean Rittmann on 9/23/20.
//  Copyright © 2020 Damean Rittmann. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    @IBOutlet weak var colorImage: UIImageView!
    @IBOutlet weak var mainTitle: UILabel!
    @IBOutlet weak var fontSizeLabel: UILabel!
    @IBOutlet weak var capSwitch: UISwitch!
    @IBOutlet weak var fontSlider: UISlider!
    @IBOutlet weak var imageControl: UISegmentedControl!
    
    
    func updateImage(){
        if imageControl.selectedSegmentIndex == 0{
            colorImage.image = UIImage(named: "blue")
            mainTitle.text = "Blue"
            mainTitle.textColor = UIColor.blue
        } else if imageControl.selectedSegmentIndex == 1{
            colorImage.image = UIImage(named: "red")
            mainTitle.text = "Red"
            mainTitle.textColor = UIColor.red
        } else if imageControl.selectedSegmentIndex == 2{
            colorImage.image = UIImage(named: "yellow")
            mainTitle.text = "Yellow"
            mainTitle.textColor = UIColor.yellow
        }
    }
    
    func updateCaps(){
        if capSwitch.isOn{
            mainTitle.text=mainTitle.text?.uppercased()
        } else{
            mainTitle.text=mainTitle.text?.lowercased()
        }
    }
    
    @IBAction func changeColor(_ sender: UISegmentedControl) {
       /* if sender.selectedSegmentIndex == 0{
            colorImage.image = UIImage(named: "blue")
            mainTitle.text = "Blue"
            mainTitle.textColor = UIColor.blue
        } else if sender.selectedSegmentIndex == 1{
            colorImage.image = UIImage(named: "red")
            mainTitle.text = "Red"
            mainTitle.textColor = UIColor.red
        } else if sender.selectedSegmentIndex == 2{
            colorImage.image = UIImage(named: "yellow")
            mainTitle.text = "Yellow"
            mainTitle.textColor = UIColor.yellow
        }
 */
        updateImage()
        updateCaps()
    }
    
    @IBAction func capital_switch(_ sender: UISwitch) {
        /*if sender.isOn{
            mainTitle.text=mainTitle.text?.uppercased()
        } else{
            mainTitle.text=mainTitle.text?.lowercased()
        }
 */
        updateCaps()
    }
    
    @IBAction func textSlider(_ sender: UISlider) {
        let fontSize = sender.value
        fontSizeLabel.text = String(format: "%.0f", fontSize)
        let fontSizeCGFloat=CGFloat(fontSize)
        mainTitle.font=UIFont.systemFont(ofSize: fontSizeCGFloat)
        //mainTitle.textColor =
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }


}

