//
//  IDTextFieldDelegate.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/24.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class IDTextFieldDelegate: NSObject, UITextFieldDelegate {
    func textField(_ textField: UITextField, shouldChangeCharactersIn range: NSRange, replacementString string: String) -> Bool {
        let length = textField.text?.count ?? 0
        
        if length < 5 {
            textField.setBorder(color: .red, width: 1)
        } else if length > 20 {
            textField.setBorder(color: .red, width: 1)
        } else {
            textField.setBorder(color: .gray, width: 1)
        }
        return true
    }
}
