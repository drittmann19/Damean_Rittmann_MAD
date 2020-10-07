//
//  ViewController.swift
//  Project1
//
//  Created by Damean Rittmann on 10/1/20.
//  Copyright © 2020 Damean Rittmann. All rights reserved.
//

import UIKit

var pickerList = [Int]()
var mealNum = 1

class ViewController: UIViewController {
    
    @IBOutlet weak var sliderNum: UILabel!
    @IBOutlet weak var chickenSwitch: UISwitch!
    @IBOutlet weak var porkSwitch: UISwitch!
    @IBOutlet weak var beefSwitch: UISwitch!
    @IBOutlet weak var vegSwitch: UISwitch!
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "mealPopup"{
            let scene2ViewController = segue.destination as! PopupViewController
            //send array values to popupviewcontroller
            let meals = createMealArray()
            //dump(meals)
            scene2ViewController.mealArray = meals
        }
    }
    
    @IBAction func getMeals(_ sender: UIButton) {
    }
    
    func createMealArray() -> Array<Int> {
        //put all of this inside func prepare(for segue:)?
        //mealNum = Int(sliderVal.value)
        print(mealNum)
        
        var meals = [Int]()
        //create array of meals
        if chickenSwitch.isOn {
            pickerList.append(contentsOf: [1,2,3,4])
        }
        if porkSwitch.isOn{
            pickerList.append(contentsOf: [5,6,7,8])
        }
        if beefSwitch.isOn{
            pickerList.append(contentsOf: [9,10,11,12,13])
        }
        if vegSwitch.isOn{
            pickerList.append(contentsOf: [14,15,16,17,18])
        }
        
        //check if length of pickerlist is bigger than mealnum, send alert if not
        
        //randomly pick meals from array
        for i in 1...mealNum{
            let length = pickerList.count
            let number = Int.random(in: 0...length-1)
            meals.append(pickerList[number])
            pickerList.remove(at: number)
            print(i)
        }
        return meals
    }
    
    @IBAction func mealSlider(_ sender: UISlider) {
        let num = sender.value
        sliderNum.text = String(format: "%.0f", num)
        mealNum = Int(num)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        pickerList = []//or put this in unwindsegue
    }

    @IBAction func unwindSegue(_ segue:UIStoryboardSegue){
        
    }
    

}
