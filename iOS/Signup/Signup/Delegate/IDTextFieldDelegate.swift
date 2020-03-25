//
//  IDTextFieldDelegate.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/24.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class IDTextFieldDelegate: NSObject, UITextFieldDelegate {
    func textFieldDidChangeSelection(_ textField: UITextField) {
        let length = textField.text?.count ?? 0
        
        if length < 5 {
            textField.setBorder(color: .red, width: 1)
            postNotification(status: .ShortLength)
        } else if length > 20 {
            textField.setBorder(color: .red, width: 1)
            postNotification(status: .LongLength)
        } else {
            if textField.text!.validateID() {
                textField.setBorder(color: .systemGreen, width: 1)
                postNotification(status: .OK)
            } else {
                textField.setBorder(color: .red, width: 1)
                postNotification(status: .InvalidID)
            }
        }
    }
    
    func postNotification(status: StatusLabel.Status) {
        NotificationCenter.default.post(name: .isValidID,
                                        object: nil,
                                        userInfo: ["status" : status])
    }
}

extension Notification.Name {
    static let isValidID = Notification.Name("isValidID")
}


