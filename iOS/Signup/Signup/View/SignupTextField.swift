//
//  IDTextField.swift
//  Signup
//
//  Created by 신한섭 on 2020/03/25.
//  Copyright © 2020 신한섭. All rights reserved.
//

import UIKit

class SignUpTextField: UITextField {
    
    enum BorderColor: String {
        case Gray
        case Green
        case Red
    }
    
    private var borderColor: BorderColor {
        didSet {
            changeBorderColor(color: borderColor)
        }
    }
    
    private func changeBorderColor(color: BorderColor) {
        DispatchQueue.main.async {
            if self.isEditing {
                if self.text?.count ?? 0 < 5 {
                    self.setBorder(color: UIColor(named: "Red") ?? .red , width: 1)
                    NotificationCenter.default.post(name: .isValidID,
                                                    object: nil,
                                                    userInfo: ["labelState" : StatusLabel.State.ShortLength])
                } else if self.text?.count ?? 0 > 20{
                    self.setBorder(color: UIColor(named: "Red") ?? .red , width: 1)
                    NotificationCenter.default.post(name: .isValidID,
                                                    object: nil,
                                                    userInfo: ["labelState" : StatusLabel.State.LongLength])
                } else {
                    self.setBorder(color: UIColor(named: color.rawValue) ?? .gray, width: 1)
                }
            }
        }
    }
    
    override init(frame: CGRect) {
        self.borderColor = .Gray
        super.init(frame: frame)
        setBorder(color: UIColor(named: borderColor.rawValue) ?? .gray, width: 1)
        NotificationCenter.default.addObserver(self,
                                               selector: #selector(changeBorderColor(_ :)),
                                               name: .borderColor,
                                               object: nil)
    }
    
    required init?(coder: NSCoder) {
        self.borderColor = .Gray
        super.init(coder: coder)
        setBorder(color: UIColor(named: borderColor.rawValue) ?? .gray, width: 1)
        NotificationCenter.default.addObserver(self,
                                               selector: #selector(changeBorderColor(_ :)),
                                               name: .borderColor,
                                               object: nil)
    }
    
    deinit {
        NotificationCenter.default.removeObserver(self)
    }
    
    @objc func changeBorderColor(_ notification: Notification) {
        if let info: [String : BorderColor] = notification.userInfo as? [String : BorderColor] {
            changeBorderColor(color: info["borderColor"] ?? .Red)
        }
    }
}
