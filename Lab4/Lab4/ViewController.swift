//
//  ViewController.swift
//  Lab4
//
//  Created by Damean Rittmann on 10/2/20.
//  Copyright © 2020 Damean Rittmann. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITextFieldDelegate{

    
    @IBOutlet weak var itemAmount: UITextField!
    @IBOutlet weak var quantityLabel: UILabel!
    @IBOutlet weak var quantityStepper: UIStepper!
    @IBOutlet weak var totalPrice: UILabel!
    
    @IBAction func updateQuantity(_ sender: UIStepper) {
        if quantityStepper.value == 1{
            quantityLabel.text = "1"
        } else {
            quantityLabel.text = String(format: "%.0f", quantityStepper.value)
        }
        findTotalAmount()
    }
    
    func findTotalAmount(){
        var price:Float
        
        if itemAmount.text!.isEmpty{
            price = 0.0
        } else{
            price = Float(itemAmount.text!)!
        }
        
        let total = price * Float(quantityStepper.value)
        
        let moneyFormat = NumberFormatter()
        moneyFormat.numberStyle = NumberFormatter.Style.currency
        totalPrice.text = moneyFormat.string(from: NSNumber(value: total))
        
        if total > 15 {
            let alert = UIAlertController(title: "Warning", message: "You can not pay for this because you only have $15 in your wallet", preferredStyle: UIAlertController.Style.alert)
            let cancelAction = UIAlertAction(title: "Ok", style: UIAlertAction.Style.cancel, handler: nil)
            alert.addAction(cancelAction)
            present(alert, animated: true, completion: nil)
        }
    }
    
    func textFieldShouldReturn(_ textField: UITextField) -> Bool {
        textField.resignFirstResponder()
        return true
    }
    
    func textFieldDidEndEditing(_ textField: UITextField) {
        findTotalAmount()
    }
    
    
    override func viewDidLoad() {
        itemAmount.delegate = self
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        
        let tap: UITapGestureRecognizer = UITapGestureRecognizer(target: self, action: #selector(self.dismissKeyboard))
        view.addGestureRecognizer(tap)
    }
    
    @objc func dismissKeyboard(){
        view.endEditing(true)
    }


}

