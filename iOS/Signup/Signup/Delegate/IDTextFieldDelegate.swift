//
//  IDTextFieldDelegate.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/24.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class IDTextFieldDelegate: NSObject, UITextFieldDelegate {
    
    private let serverURL = "http://www.mocky.io/v2/5e7b121a2d00002b00119be2"
    
    func textFieldDidChangeSelection(_ textField: UITextField) {
        guard let IDTextField = textField as? SignUpTextField else {return}
        
        let length = IDTextField.text?.count ?? 0
        
        if length < 5 {
            
            postNotification(state: .ShortLength)
        } else if length > 20 {
            IDTextField.borderColor = .Red
            postNotification(state: .LongLength)
        } else {
            if textField.text!.validateID() {
                IDTextField.borderColor = .Green
                postNotification(state: .OK)
                NetworkHandler.request(resource: serverURL)
            } else {
                IDTextField.borderColor = .Red
                postNotification(state: .InvalidID)
            }
        }
    }

    func postNotification(state: StatusLabel.State) {
        NotificationCenter.default.post(name: .isValidID,
                                        object: nil,
                                        userInfo: ["state" : state])
    }
}

extension Notification.Name {
    static let isValidID = Notification.Name("isValidID")
}


