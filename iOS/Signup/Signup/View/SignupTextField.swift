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
    
    var borderColor: BorderColor {
        didSet {
            changeBorderColor(color: borderColor)
        }
    }
    
    private func changeBorderColor(color: BorderColor) {
        setBorder(color: UIColor(named: color.rawValue) ?? .gray, width: 1)
    }
    
    override init(frame: CGRect) {
        self.borderColor = .Gray
        super.init(frame: frame)
        setBorder(color: UIColor(named: borderColor.rawValue) ?? .gray, width: 1)
    }
    
    required init?(coder: NSCoder) {
        self.borderColor = .Gray
        super.init(coder: coder)
        setBorder(color: UIColor(named: borderColor.rawValue) ?? .gray, width: 1)
    }
}
