//
//  BirthdayTextFieldDelegate.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/27.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class BirthdayTextFieldDelegate: NSObject, UITextFieldDelegate {
    
    func textFieldShouldBeginEditing(_ textField: UITextField) -> Bool {
        let datePicker = UIDatePicker()
        datePicker.datePickerMode = .date
        textField.inputView = datePicker
        return true
    }
}
